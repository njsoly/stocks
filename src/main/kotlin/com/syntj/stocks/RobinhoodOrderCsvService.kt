package com.syntj.stocks

import com.syntj.stocks.representations.robinhood.OrderFromCsv
import java.nio.file.Files
import java.nio.file.Path
import kotlin.reflect.full.declaredMemberProperties

/**
 * This class loads a few key points for every order, as output to CSV from Robinhood, with the help of
 * the LichAmnesia repo.
 *
 * Get an order history by:
 * * cloning  https://github.com/LichAmnesia/Robinhood
 * * copy trade_history_downloader.py up to the main directory
 * * enter your actual account details in the username & password spots (but don't commit & push!)
 * * run it with python
 * * you'll need to grab an SMS challenge code in order for it log you in
 * * you should see a local file generated under the name orders.csv
 *
 * Tested by [RobinhoodOrderCsvService_TestRun][com.syntj.stocks.testrun.RobinhoodOrderCsvService_TestRun]
 * (full load from file)
 */
class RobinhoodOrderCsvService (pathString: String = DEFAULT_PATH){

    companion object {
        const val DEFAULT_PATH: String = "data/orders.csv"
    }

    private val path: Path = Path.of(pathString).toAbsolutePath()

    init {
        if (!Files.exists(path)) {
            throw Exception("File \"${path}\" does not exist.")
        }
    }

    fun loadAllNonBlankLinesFromFile(): List<String> {
        val f: List<String> = Files.readAllLines(path).filter {it.isNotBlank()}
        println("found ${f.size} lines in ${path.fileName}")
        return f
    }

    fun loadAllOrdersFromFile(): List<OrderFromCsv> {
        val lines = loadAllNonBlankLinesFromFile().toMutableList()
        if (lines.isEmpty()) {
            throw Exception("no lines recovered from file")
        }

        verifyHeaderLineMatchesDataClass(lines.removeAt(0))

        val orders = ArrayList<OrderFromCsv>()

        for (line in lines) {
            orders.add(OrderFromCsv.fromString(line))
        }
        return orders
    }

    private fun verifyHeaderLineMatchesDataClass(headerLineRaw: String) {
        val header = headerLineRaw.split(",")
        if (header.size != OrderFromCsv::class.declaredMemberProperties.size) {
            throw AssertionError(
                "header size: ${header.size}; " +
                        "expected ${OrderFromCsv::class.declaredMemberProperties.size}"
            )
        } else if (header != OrderFromCsv.expectedCsvHeaderRow) {
            throw AssertionError("header from CSV does not match what is expected in OrderFromCsv class")
        }

    }
}

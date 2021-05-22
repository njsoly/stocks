package com.syntj.stocks

import com.syntj.stocks.representations.robinhood.OrderFromCsv
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
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
open class RobinhoodOrderCsvService (pathString: String = DEFAULT_PATH){

    companion object {
        const val DEFAULT_PATH: String = "data/orders.csv"
    }

    private val defaultPath: Path = Path.of(pathString).toAbsolutePath()
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    init {
        if (!Files.exists(defaultPath)) {
            throw Exception("File \"${defaultPath}\" does not exist.")
        }
    }

    private fun loadAllNonBlankLinesFromFile(filePath: Path = defaultPath): List<String> {
        val f: List<String> = Files.readAllLines(filePath).filter {it.isNotBlank()}
        logger.debug("found ${f.size} lines in ${filePath.fileName}")
        return f
    }

    /**
     * Given a [Path], turn every non-blank line into an [OrderFromCsv]
     * (except for the first line, which is the header).
     */
    fun loadAllOrdersFromFile(path: Path = defaultPath): List<OrderFromCsv> {
        val lines = loadAllNonBlankLinesFromFile(path).toMutableList()
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

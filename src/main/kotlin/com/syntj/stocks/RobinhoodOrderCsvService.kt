package com.syntj.stocks

import com.syntj.stocks.representations.robinhood.OrderFromCsv
import java.nio.file.Files
import java.nio.file.Path

/**
 * This class loads a few key points for every order, as output to CSV from Robinhood, with the help of
 * the LichAmnesia repo.
 *
 * Get an order history by:
 * * cloning  https://github.com/LichAmnesia/Robinhood
 * * copy trade_history_downloader.py up to the main directory
 * * enter your actual account details in the username & password spots
 * * run it with python
 * * you'll need to grab an SMS challenge code in order for it log you in
 *
 * Tested by [RobinhoodOrderCsvService_TestRun][com.syntj.stocks.testrun.RobinhoodOrderCsvService_TestRun]
 * (full load from file)
 */
class RobinhoodOrderCsvService {

    companion object {
        const val DEFAULT_PATH: String = "data/orders.csv"
    }

    fun loadAllNonBlankLinesFromFile(pathString: String = DEFAULT_PATH): List<String> {
        val path: Path = Path.of(pathString)

        if (!Files.exists(path)) {
            throw Exception("File \"${path.fileName}\" does not exist.")
        }
        val f: List<String> = Files.readAllLines(path).filter {it.isNotBlank()}
        println("found ${f.size} lines in ${path.fileName}")
        return f
    }

    fun loadAllOrdersFromFile(pathString: String = DEFAULT_PATH): List<OrderFromCsv> {
        val lines = loadAllNonBlankLinesFromFile(pathString).toMutableList()
        if (lines.isEmpty()) {
            throw Exception("no lines recovered from file")
        }
        val header = lines.removeAt(0).split(",")
        if (header.size != OrderFromCsv::class.java.declaredFields.size) {
            throw AssertionError(
                "header size: ${header.size}; " +
                        "expected ${OrderFromCsv::class.java.declaredFields.size}"
            )
        }

        val orders = ArrayList<OrderFromCsv>()

        for (line in lines) {
            val values = line.split(",")
            orders.add(OrderFromCsv(
                side = values[header.indexOf("side")],
                symbol = values[header.indexOf("symbol")],
                shares = values[header.indexOf("shares")],
                price = values[header.indexOf("price")],
                date = values[header.indexOf("date")],
                state = values[header.indexOf("state")]
            ))
        }
        return orders
    }
}

/** test run. */
fun main() {
    RobinhoodOrderCsvService().loadAllNonBlankLinesFromFile().forEach{
        println(it)
    }
    println()
    RobinhoodOrderCsvService().loadAllOrdersFromFile().forEach{
        println(it)
    }

}

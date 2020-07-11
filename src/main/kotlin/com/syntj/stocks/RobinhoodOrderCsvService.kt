package com.syntj.stocks

import java.io.File
import java.nio.file.Files
import java.nio.file.Path

/**
 * Get an order history by:
 * * cloning  https://github.com/LichAmnesia/Robinhood
 * * copy trade_history_downloader.py up to the main directory
 * * enter your actual account details in the username & password spots
 * * run it with python
 * * you'll need to grab an SMS challenge code in order for it log you in
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
}

/** test run. */
fun main() {
    RobinhoodOrderCsvService().loadAllNonBlankLinesFromFile().forEach{
        println(it)
    }

}

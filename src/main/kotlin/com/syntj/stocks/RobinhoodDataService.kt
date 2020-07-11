package com.syntj.stocks

import com.syntj.stocks.representations.robinhood.OrderFromCsv
import java.util.logging.Logger

/**
 * Python repo to get order history, portfolio, and positions info:
 * https://github.com/LichAmnesia/Robinhood
 * You can even make trades.... be careful
 * before using the main executables, call py install setup.py.
 */
class RobinhoodDataService {

    // TODO new data class for single order
    // TODO new data class for order history

    private val robinhoodInstrumentService = RobinhoodInstrumentService()
    private val robinhoodOrderCsvService = RobinhoodOrderCsvService()
    private val logger: Logger = Logger.getLogger(javaClass.simpleName)

    /** retrieving this URL will get you information about MSFT, and it matches that of
     * the [instrument] fields of order_history. */


    fun getMsftInstrument(): String {
        return robinhoodInstrumentService.getMsftInstrument()
    }

    fun getOrdersFromCsv() : List<OrderFromCsv> {
        return robinhoodOrderCsvService.loadAllOrdersFromFile()
    }

}

fun main() {
    val robinhoodDataService = RobinhoodDataService()
    print(robinhoodDataService.getMsftInstrument())

    print(robinhoodDataService.getOrdersFromCsv())
}
package com.syntj.stocks

import com.syntj.stocks.representations.robinhood.OrderFromCsv
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Python repo to get order history, portfolio, and positions info:
 * https://github.com/LichAmnesia/Robinhood
 * You can even make trades.... be careful
 * before using the main executables, call py install setup.py.
 *
 * Test run: RobinhoodDataService_TestRun
 */
class RobinhoodDataService (
    val robinhoodInstrumentService: RobinhoodInstrumentService = RobinhoodInstrumentService(),
    val robinhoodOrderCsvService: RobinhoodOrderCsvService = RobinhoodOrderCsvService()){

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    /** retrieving this URL will get you information about MSFT, and it matches that of
     * the [instrument] fields of order_history. */


    fun getMsftInstrument(): String {
        return robinhoodInstrumentService.getMsftInstrument()
    }

    fun getOrdersFromCsv() : List<OrderFromCsv> {
        return robinhoodOrderCsvService.loadAllOrdersFromFile()
    }

    fun getSymbolsFromOrders(ordersList: List<OrderFromCsv>? = null) : List<String> {
        val orders = ordersList ?: getOrdersFromCsv()
        val symbols = mutableSetOf<String>()
        orders.forEach{order ->
            symbols.add(order.symbol)
        }
        logger.info("${symbols.size} symbols found in ${orders.size} orders.")
        return symbols.toList().sorted()
    }

}

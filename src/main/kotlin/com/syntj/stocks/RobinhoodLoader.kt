package com.syntj.stocks

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.logging.Logger

class RobinhoodLoader {

    // TODO new data class for single order
    // TODO new data class for order history

    val robinhoodInstrumentService = RobinhoodInstrumentService()

    private val logger: Logger = Logger.getLogger(javaClass.simpleName)

    /** retrieving this URL will get you information about MSFT, and it matches that of
     * the [instrument] fields of order_history. */


}

fun main() {
    print(RobinhoodLoader().robinhoodInstrumentService.getMsftInstrument())
}
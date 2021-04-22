package com.syntj.stocks

import java.net.http.HttpResponse
import java.util.logging.Logger

class NjStocks {

    private val logger = Logger.getLogger(javaClass.simpleName)

    fun run() {
        println("************** NjStocks **************")

        val quoteString: String = FinnhubRequester().requestQuoteAsString(WatchedStock.DBX)

        println(quoteString)

    }
}

fun main() {
    NjStocks().run()
}

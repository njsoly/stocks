package com.syntj.stocks

import java.net.http.HttpResponse
import java.util.logging.Logger

class NjStocks {

    private val logger = Logger.getLogger(javaClass.simpleName)

    fun run() {
        println("************** NjStocks **************")

        val quoteString: HttpResponse<String> = FinnhubRequester().requestQuoteAsString(WatchedStock.DBX)

        println(quoteString.body())

    }
}

fun main() {
    NjStocks().run()
}

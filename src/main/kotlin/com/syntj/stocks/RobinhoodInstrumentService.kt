package com.syntj.stocks

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class RobinhoodInstrumentService : HttpGetter() {

    val MSFT_INSTRUMENT_URL = "https://api.robinhood.com/instruments/50810c35-d215-4866-9758-0ada4ac79ffa/"


    fun getMsftInstrument(): String {
        return getInstrumentStringFromUrl(MSFT_INSTRUMENT_URL)
    }

    fun getInstrumentStringFromUrl(instrumentUrl: String) : String {
        return getRequest(instrumentUrl).body() as String
    }
}
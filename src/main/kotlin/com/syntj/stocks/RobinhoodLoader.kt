package com.syntj.stocks

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.logging.Logger

class RobinhoodLoader {

    private val logger: Logger = Logger.getLogger(javaClass.simpleName)

    private val client: HttpClient = HttpClient.newHttpClient()

    /** retrieving this URL will get you information about MSFT, and it matches that of
     * the [instrument] fields of order_history. */
    val MSFT_INSTRUMENT_URL = "https://api.robinhood.com/instruments/50810c35-d215-4866-9758-0ada4ac79ffa/"

    /**
     * build and send for QUOTE endpoint to Finnhub API
     * expect a return in this form:
     * {"c":21.03,"h":21.28,"l":20.55,"o":21.04,"pc":20.42,"t":1592040051}
     */
    fun getRequest(uri: URI) : HttpResponse<String> {
        val request: HttpRequest = HttpRequest.newBuilder(uri).build()

        val bodyHandler: HttpResponse.BodyHandler<String> = HttpResponse.BodyHandlers.ofString()

        return client.send(request, bodyHandler)
    }

    fun getRequest(uriString: String) : HttpResponse<String> {
        return getRequest(URI(uriString))
    }

    fun getMsftInstrument(): String {
        return getInstrumentStringFromUrl(MSFT_INSTRUMENT_URL)
    }
    
    fun getInstrumentStringFromUrl(instrumentUrl: String) : String {
        return getRequest(instrumentUrl).body() as String
    }
}

fun main() {
    print(RobinhoodLoader().getMsftInstrument())
}
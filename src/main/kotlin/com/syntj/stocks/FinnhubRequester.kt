package com.syntj.stocks


import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

/**
 * Query the Finnhub API
 * https://finnhub.io
 *
 */
class FinnhubRequester {

    companion object {
        val API_KEY: String? = EnvGetter().getEnv(EnvGetter.FINNHUB_API_KEY)
        const val BASE_URI_QUOTE = "https://finnhub.io/api/v1/quote"

    }

    private val logger: Logger = LoggerFactory.getLogger(FinnhubRequester::class.java)

    private val client: HttpClient = HttpClient.newHttpClient()

    init {
        if (API_KEY == null) {
            logger.warn("API_KEY for Finnhub not found in environment.")
        }
    }

    /**
     * build and send for QUOTE endpoint to Finnhub API
     * expect a return in this form:
     * {"c":21.03,"h":21.28,"l":20.55,"o":21.04,"pc":20.42,"t":1592040051}
     */
    fun requestQuoteAsString(symbol: String) : HttpResponse<String> {
        val request: HttpRequest = HttpRequest.newBuilder(
            URI(buildQuoteRequestUri(symbol))
        ).build()

        val bodyHandler: HttpResponse.BodyHandler<String> = HttpResponse.BodyHandlers.ofString()

        return client.send(request, bodyHandler)
    }

    fun requestQuoteAsString(symbol: WatchedStock) : HttpResponse<String> {
        return requestQuoteAsString(symbol.name)
    }

    private fun buildQuoteRequestUri(symbol: String): String {
        var uri = "$BASE_URI_QUOTE?symbol=$symbol"
        if (API_KEY != null){
            uri += "&token=${API_KEY}"
        }
        logger.info("uri for quote $symbol: $uri")
        return uri
    }

    private fun buildQuoteRequestUri(symbol: WatchedStock): String {
        return buildQuoteRequestUri(symbol.name)
    }
}

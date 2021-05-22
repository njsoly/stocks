package com.syntj.stocks

class RobinhoodApiClient {

    companion object {
        const val quoteBaseUrl: String = "https://api.robinhood.com/quotes/"
        const val apiUrl: String = "https://api.robinhood.com"
        const val loginUrl = "$apiUrl/oauth2/token/"
    }

    // TODO get this to work.  It returns a 401.  Probably need to log in.
    fun getQuote(symbol: String) : String{
        val urlString = "$quoteBaseUrl$symbol/"
        println("going to request $urlString")
        val response = HttpGetter().getRequest(urlString)

        return response.body()
    }

}

fun main() {
    val client = RobinhoodApiClient()
    println(client.getQuote("PLUG"))
}
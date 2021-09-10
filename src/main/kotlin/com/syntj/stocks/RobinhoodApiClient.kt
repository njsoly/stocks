package com.syntj.stocks

import org.springframework.stereotype.Component

@Component
class RobinhoodApiClient {

    companion object {
        const val quoteBaseUrl: String = "https://api.robinhood.com/quotes/"
        const val apiUrl: String = "https://api.robinhood.com"
        const val loginUrl = "$apiUrl/oauth2/token/"
        const val clientId = "c82SH0WZOsabOXGP2sxqcj34FxkvfnWRZBKlBjFS"
        const val grantType = "password"
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
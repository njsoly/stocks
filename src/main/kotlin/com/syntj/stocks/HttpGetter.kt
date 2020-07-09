package com.syntj.stocks

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

open class HttpGetter(public val client: HttpClient = HttpClient.newHttpClient()) {

    /**
     *
     */
    fun getRequest(uri: URI) : HttpResponse<String> {
        val request: HttpRequest = HttpRequest.newBuilder(uri).build()

        val bodyHandler: HttpResponse.BodyHandler<String> = HttpResponse.BodyHandlers.ofString()

        return client.send(request, bodyHandler)
    }

    fun getRequest(uriString: String) : HttpResponse<String> {
        return getRequest(URI(uriString))
    }
}
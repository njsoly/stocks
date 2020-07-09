package com.syntj.stocks

import com.fasterxml.jackson.annotation.JsonProperty

/** OHLC data, as returned from FinnHub. */
data class Ohlc(
    @JsonProperty("c")
    val current: Double,

    @JsonProperty("h")
    val high: Double,

    @JsonProperty("l")
    val l: Double,

    @JsonProperty("o")
    val o: Double,

    @JsonProperty("pc")
    val previousClose: Double,

    @JsonProperty("t")
    val time: Long
)
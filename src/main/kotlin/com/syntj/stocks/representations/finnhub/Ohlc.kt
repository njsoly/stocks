package com.syntj.stocks.representations.finnhub

import com.fasterxml.jackson.annotation.JsonProperty

/** OHLC data, as returned from FinnHub. */
data class Ohlc(
    @JsonProperty("c")
    val current: Double,

    @JsonProperty("h")
    val high: Double,

    @JsonProperty("l")
    val low: Double,

    @JsonProperty("o")
    val open: Double,

    @JsonProperty("pc")
    val previousClose: Double,

    @JsonProperty("t")
    val time: Long
)
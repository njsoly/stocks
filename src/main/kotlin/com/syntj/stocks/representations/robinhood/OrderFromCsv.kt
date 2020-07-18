package com.syntj.stocks.representations.robinhood

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Robinhood order history record from csv file,
 * as read in by trade_history_downloader.py.
 */
data class OrderFromCsv (
    @JsonProperty("side")
    val side: String,
    @JsonProperty("symbol")
    val symbol: String,
    @JsonProperty("shares")
    val shares: String,
    @JsonProperty("price")
    val price: String,
    @JsonProperty("date")
    val date: String,
    @JsonProperty("state")
    val status: String
)
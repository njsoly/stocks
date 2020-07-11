package com.syntj.stocks.representations.robinhood

/**
 * Robinhood order history record from csv file,
 * as read in by trade_history_downloader.py.
 */
data class OrderFromCsv (
    val side: String,
    val symbol: String,
    val shares: String,
    val price: String,
    val date: String,
    val state: String
)
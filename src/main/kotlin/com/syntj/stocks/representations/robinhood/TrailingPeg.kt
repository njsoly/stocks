package com.syntj.stocks.representations.robinhood

/**
 * see [trailingPeg.sample.json]
 */
data class TrailingPeg (
    val type: String,
    val percentage: String?,
    val price: Notional?
)
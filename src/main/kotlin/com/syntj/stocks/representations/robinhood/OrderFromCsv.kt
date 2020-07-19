package com.syntj.stocks.representations.robinhood

import com.fasterxml.jackson.annotation.JsonProperty
import com.syntj.stocks.DateUtil
import java.time.LocalDateTime

/**
 * Robinhood order history record from csv file,
 * as read in by trade_history_downloader.py.
 */
data class OrderFromCsv(
    @JsonProperty("side")
    val side: String,
    @JsonProperty("symbol")
    val symbol: String,
    @JsonProperty("shares")
    val shares: String,
    @JsonProperty("price")
    val price: String,
    @JsonProperty("date")
    val date: LocalDateTime,
    @JsonProperty("state")
    val status: String
) {

    companion object {

        val csvHeaderRow = listOf("side", "symbol", "shares", "price", "date", "state")

        fun fromString (rawLine: String) : OrderFromCsv {
            val values = rawLine.split(",")
            return OrderFromCsv(
                values[csvHeaderRow.indexOf("side")],
                values[csvHeaderRow.indexOf("symbol")],
                values[csvHeaderRow.indexOf("shares")],
                values[csvHeaderRow.indexOf("price")],
                DateUtil.getZonedDateTimeFromInstantString(values[csvHeaderRow.indexOf("date")]).toLocalDateTime(),
                values[csvHeaderRow.indexOf("state")]
            )
        }
    }
}
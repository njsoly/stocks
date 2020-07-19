package com.syntj.stocks.representations.robinhood

import com.fasterxml.jackson.annotation.JsonProperty
import com.syntj.stocks.DateUtil
import java.time.LocalDateTime

/**
 * Robinhood order history record from csv file,
 * as read in by trade_history_downloader.py.
 */
data class OrderFromCsv(
    /** buy or sell */
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

        // TODO actually make this list the JsonProperty values rather than hard code them
        val expectedCsvHeaderRow = listOf("side", "symbol", "shares", "price", "date", "state")

        /** Construct an [OrderFromCsv] object from an as-is line from the file. */
        fun fromString (rawLine: String) : OrderFromCsv {
            val values = rawLine.split(",")
            return OrderFromCsv(
                values[expectedCsvHeaderRow.indexOf("side")],
                values[expectedCsvHeaderRow.indexOf("symbol")],
                values[expectedCsvHeaderRow.indexOf("shares")],
                values[expectedCsvHeaderRow.indexOf("price")],
                DateUtil.getZonedDateTimeFromInstantString(values[expectedCsvHeaderRow.indexOf("date")]).toLocalDateTime(),
                values[expectedCsvHeaderRow.indexOf("state")]
            )
        }
    }
}
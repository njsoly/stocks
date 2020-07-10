package com.syntj.stocks.representations.robinhood

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

/**
 * Example: "executions": [{"price": "0.90700000", "quantity": "8.00000000", "settlement_date": "2020-07-10", "timestamp": "2020-07-08T19:55:00.475000Z", "id": "97c4cf20-fa80-4ea3-988b-4a117cbeb39d"}]
 */
data class Execution (
    val price: String,
    val quantity: String,
    @JsonProperty("settlement_date")
    val settlementDate: String,
    val timestamp: String,
    val id: String
)
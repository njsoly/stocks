package com.syntj.stocks.representations.robinhood

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * example:
 * "executed_notional": {"amount": "7.26", "currency_code": "USD", "currency_id": "1072fc76-1862-41ab-82c2-485837590762"}
 */
class ExecutedNotional (
    val amount: String,
    @JsonProperty("currency_code")
    val currencyCode: String,
    @JsonProperty("currency_id")
    val currencyId: String
)

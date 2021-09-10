package com.syntj.stocks.representations.robinhood

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

/**
 * example:
 * "executed_notional": {"amount": "7.26", "currency_code": "USD", "currency_id": "1072fc76-1862-41ab-82c2-485837590762"}
 */
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy::class)
data class Notional (
    val amount: String,
    val currencyCode: String,
    val currencyId: String
)

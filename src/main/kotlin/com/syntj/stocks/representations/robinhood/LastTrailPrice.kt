package com.syntj.stocks.representations.robinhood

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

/**
 * See lastTrailPrice.sample.json.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class LastTrailPrice (
    val amount: String,
    val currencyCode: String,
    val currencyId: String
)
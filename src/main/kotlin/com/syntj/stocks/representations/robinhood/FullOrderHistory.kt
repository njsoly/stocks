package com.syntj.stocks.representations.robinhood

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy::class)
data class FullOrderHistory (
    val orders: List<RawRobinhoodOrder>
)

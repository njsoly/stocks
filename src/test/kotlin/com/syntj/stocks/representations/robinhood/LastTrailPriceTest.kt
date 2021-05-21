package com.syntj.stocks.representations.robinhood

import com.syntj.BaseUnitTest
import org.junit.Test

class LastTrailPriceTest: BaseUnitTest() {
    private val sample = this.loadTestFile("lastTrailPrice.sample.json").joinToString()

    @Test
    fun `read in a LastTrailPrice` () {
        val result: LastTrailPrice = objectMapper.readValue(sample, LastTrailPrice::class.java)
        println(result)
    }
}
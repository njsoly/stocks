package com.syntj.stocks.representations.robinhood

import com.syntj.BaseUnitTest
import org.junit.Test

class FullOrderHistoryTest: BaseUnitTest() {
    private val sample = this.loadTestFile("fullOrderHistory.sample.json").joinToString()

    @Test
    fun `read in a FullOrderHistory` () {
        val result: FullOrderHistory = objectMapper.readValue(sample, FullOrderHistory::class.java)
        println(result)
    }
}
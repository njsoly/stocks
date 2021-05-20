package com.syntj.stocks.representations.robinhood

import com.syntj.BaseUnitTest
import org.junit.Test

class RawRobinhoodOrderTest : BaseUnitTest() {
    private val sample = this.loadTestFile("order.sample.json").joinToString()

    @Test
    fun `read in a RawRobinhoodOrder` () {
        val result: RawRobinhoodOrder = objectMapper.readValue(sample, RawRobinhoodOrder::class.java)
        println(result)
    }
}
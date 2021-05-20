package com.syntj.stocks.representations.robinhood

import com.syntj.BaseUnitTest
import org.junit.Test

class TrailingPegTest: BaseUnitTest() {
    val sample = this.loadTestFile("trailingPeg.sample.json").joinToString()

    @Test
    fun `read in a TrailingPeg` () {
        val result = objectMapper.readValue(sample, TrailingPeg::class.java)
        println(result)
    }
}
package com.syntj.stocks.representations.robinhood

import com.syntj.BaseUnitTest
import org.junit.Test

class ExecutionTest : BaseUnitTest() {

    private val sample = this.loadTestFile("execution.sample.json").joinToString()

    @Test
    fun `read in an Execution` () {
        val result = objectMapper.readValue(sample, Execution::class.java)
        println(result)
    }
}
package com.syntj.stocks.representations.robinhood

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.syntj.BaseUnitTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ExecutedNotionalTest: BaseUnitTest() {

    private val EXAMPLE: String = "{\"amount\":\"7.26\",\"currency_code\":\"USD\",\"currency_id\":\"1072fc76-1862-41ab-82c2-485837590762\"}"
    private val objectMapper = ObjectMapper().registerModule(KotlinModule())

    @Test
    fun `deserialize-serialize results in same string`() {
        val en: ExecutedNotional = objectMapper.readValue(EXAMPLE, ExecutedNotional::class.java)
        val str: String = objectMapper.writeValueAsString(en)

        assertEquals(EXAMPLE, str)
    }
}

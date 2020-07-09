package com.syntj.stocks.representations.robinhood

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ExecutedNotionalTest {
    val EXAMPLE: String = "{\"amount\":\"7.26\",\"currency_code\":\"USD\",\"currency_id\":\"1072fc76-1862-41ab-82c2-485837590762\"}"

    val objectMapper = ObjectMapper().registerModule(KotlinModule())

    @Before
    fun setup() {

    }
    @Test
    fun deserialize() {
        val en: ExecutedNotional = objectMapper.readValue(EXAMPLE, ExecutedNotional::class.java)
        val str: String = objectMapper.writeValueAsString(en)

        assertEquals(EXAMPLE, str)
    }
}
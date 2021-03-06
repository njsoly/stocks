package com.syntj.stocks.representations.finnhub

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset

class OhlcTest {

    private val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())

    companion object {
        const val SAMPLE_FINNHUB_QUOTE_JSON = "{\"c\":21.03,\"h\":21.28,\"l\":20.55,\"o\":21.04,\"pc\":20.42,\"t\":1592040051}"
    }

    @Test
    fun `test constructor`() {
        val tester = Ohlc(0.1, 0.1, 0.05, 0.1, 0.08, 989874)
    }

    @Test
    fun `serilializing object works as expected`() {
        val ohlc = Ohlc(
            21.03,
            21.28,
            20.55,
            21.04,
            20.42,
            1592040051L
        )
        val serialized = mapper.writeValueAsString(ohlc)
        val json = SAMPLE_FINNHUB_QUOTE_JSON

        assertEquals(serialized, json)
    }

    @Test
    fun `given JSON for Ohlc, deserialize correctly`() {
        val json =
            SAMPLE_FINNHUB_QUOTE_JSON
        val ohlc = Ohlc(
            21.03,
            21.28,
            20.55,
            21.04,
            20.42,
            1592040051L
        )
        val ohlcDeserialized: Ohlc = mapper.readValue(json)
        val time: LocalDateTime = LocalDateTime.ofEpochSecond(ohlc.time, 0, ZoneOffset.UTC)

        assertEquals(ohlc, ohlcDeserialized)
        assertEquals(true, time.isBefore(LocalDateTime.now()))
    }
}

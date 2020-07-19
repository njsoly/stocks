package com.syntj.stocks

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month

@RunWith(MockitoJUnitRunner::class)
class StockMarketDateUtilTest : BaseUnitTest() {

    @Test
    fun `getMondayOfTradeWeek() given 2020-01-01 returns 2019-12-30`() {
        val result = StockMarketDateUtil.getMondayOfTradeWeek(LocalDateTime.of(2020,1,1,0,44))
        assertEquals(LocalDate.of(2019, 12, 30), result)
    }

    @Test
    fun `getMondayOfTradeWeek() given 2020-06-03 returns 2020-06-01`() {
        val result = StockMarketDateUtil.getMondayOfTradeWeek(LocalDateTime.of(2020, 6, 3, 11, 11))
        assertEquals(LocalDate.of(2020, 6, 1), result)
    }

    @Test
    fun `getMondayOfTradeWeek() given 2018-01-07 returns 2018-01-01`() {
        val result = StockMarketDateUtil.getMondayOfTradeWeek(LocalDateTime.of(2018, 1, 7, 11, 59, 59, 99999))
        assertEquals(LocalDate.of(2018, 1, 1), result)
    }
}

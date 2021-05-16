package com.syntj.stocks

import com.syntj.BaseUnitTest
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.Instant
import java.time.ZoneId
import java.time.temporal.ChronoField

/** tests [DateUtil]. */
class DateUtilTest : BaseUnitTest() {

    private val INSTANT_STRING_UTC = "2020-06-03T15:22:00.726000Z"
    private val INSTANT_20200603 = Instant.ofEpochMilli(1621148304641) // represents 2021-05-16T06:58:24.641Z

    @Test
    fun `getZonedDateTimeFromInstantString with valid string does not throw error`() {
        val result = DateUtil.getZonedDateTimeFromInstantString(INSTANT_STRING_UTC)
        assertEquals(10, result.hour)
    }

    @Test
    fun `print time from clocks` () {
        val central = DateUtil.CLOCK_CENTRAL_TIME.millis()
        val utc = DateUtil.CLOCK_UTC.millis()

        println("Central time millis: $central")
        println("UTC millis: $utc")
    }

    @Test
    fun `demonstrate UTC string converted to LocalDate` () {
        println("ISO-8601 string: $INSTANT_STRING_UTC")
        println("In LocalDate form: ${DateUtil.getZonedDateTimeFromInstantString(INSTANT_STRING_UTC).toLocalDateTime()}")
    }

    @Test
    fun `YYYYMMDD_FORMATTER formats YYYY-MM-DD correctly` () {
        println("Instant in ISO-8601 form: $INSTANT_20200603")

        val instant = INSTANT_20200603.atZone(DateUtil.FORMATTER_YYYYMMDD.zone)
        val result = DateUtil.FORMATTER_YYYYMMDD.format(INSTANT_20200603)
        println("Formatted with YYYYMMDD_FORMATTER: $result")
        assertEquals(
            instant.get(ChronoField.YEAR).toString(),
            result.split('-').first()
        )
        assertEquals(
            instant.get(ChronoField.MONTH_OF_YEAR).toString().padStart(2, '0'),
            result.split('-')[1]
        )
        assertEquals(
            instant.get(ChronoField.DAY_OF_MONTH).toString().padStart(2, '0'),
            result.split('-')[2]
        )
        assertEquals(10, result.length)

    }
}


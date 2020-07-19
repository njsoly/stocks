package com.syntj.stocks

import com.syntj.BaseUnitTest
import org.junit.Assert.*
import org.junit.Test

/** tests [DateUtil]. */
class DateUtilTest : BaseUnitTest() {

    private val INSTANT_STRING_UTC = "2020-06-03T15:22:00.726000Z"

    @Test
    fun `getZonedDateTimeFromInstantString with valid string does not throw error`() {
        val result = DateUtil.getZonedDateTimeFromInstantString(INSTANT_STRING_UTC)
        assertEquals(10, result.hour)
    }
}

package com.syntj.stocks

import java.time.Clock
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 * @see [StockMarketDateUtil]
 *
 * tested by [DateUtilTest].
 * */
open class DateUtil {

    companion object {

        val CENTRAL_TIME_ZONE: ZoneId = ZoneId.of("America/Chicago")
        val UTC_ZONE: ZoneId = ZoneId.of("UTC")

        val CLOCK_UTC = Clock.systemUTC()
        val CLOCK_CENTRAL_TIME = Clock.system(CENTRAL_TIME_ZONE)

        fun getZonedDateTimeFromInstantString(dateTimeInstantString: String): ZonedDateTime {
            return ZonedDateTime.parse(
                dateTimeInstantString,
                DateTimeFormatter.ISO_INSTANT.withZone(DateUtil.CENTRAL_TIME_ZONE)
            )
        }

    }
}

package com.syntj.stocks

import java.time.Clock
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField

/**
 * @see [StockMarketDateUtil]
 *
 * tested by [DateUtilTest][com.syntj.stocks.DateUtilTest].
 * */
open class DateUtil {

    companion object {

        private val CENTRAL_TIME_ZONE: ZoneId = ZoneId.of("America/Chicago")
        val UTC_ZONE: ZoneId = ZoneId.of("UTC")

        val CLOCK_UTC: Clock = Clock.systemUTC()
        val CLOCK_CENTRAL_TIME: Clock = Clock.system(CENTRAL_TIME_ZONE)

        fun getZonedDateTimeFromInstantString(dateTimeInstantString: String): ZonedDateTime {
            return ZonedDateTime.parse(
                dateTimeInstantString,
                DateTimeFormatter.ISO_INSTANT.withZone(DateUtil.CENTRAL_TIME_ZONE)
            )
        }

        val FORMATTER_YYYYMMDD: DateTimeFormatter = DateTimeFormatterBuilder()
            .appendValue(ChronoField.YEAR, 4)
            .appendLiteral('-')
            .appendValue(ChronoField.MONTH_OF_YEAR, 2)
            .appendLiteral('-')
            .appendValue(ChronoField.DAY_OF_MONTH, 2)
            .toFormatter()
            .withZone(ZoneId.of("America/Chicago"))

    }

}


fun String.toSimplerDateTimeString() : String {
    return this.replace('T', ' ').split('.').first()
}

fun ZonedDateTime.getDD() : String {
    return this.get(ChronoField.DAY_OF_MONTH).toString().padStart(2, '0')
}

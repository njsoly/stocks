package com.syntj.stocks

import java.time.LocalDate
import java.time.LocalDateTime

class StockMarketDateUtil : DateUtil() {

    companion object {
        /**
         * Get the Monday that came before this date, unless it's during a Monday itself,
         * therefore getting the day which marks the start of the current trade week.
         *
         * TODO: go forward for Sat-Sun ?
         */
        fun getMondayOfTradeWeek(localDateTime: LocalDateTime) : LocalDate{
            return LocalDate.ofYearDay(2020, (localDateTime.dayOfYear / 7) * 7 - 1)
        }
    }
}
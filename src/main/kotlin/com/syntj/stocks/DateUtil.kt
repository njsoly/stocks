package com.syntj.stocks

import java.time.ZoneId

class DateUtil {

    companion object {
        val CENTRAL_TIME_ZONE: ZoneId = ZoneId.of("America/Chicago")
        val UTC_ZONE: ZoneId = ZoneId.of("UTC")
    }
}
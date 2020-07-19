package com.syntj.stocks

import org.junit.Assert.*
import org.junit.Test

class RobinhoodOrderCsvServiceTest : BaseUnitTest() {

    private val robinhoodOrderCsvService = RobinhoodOrderCsvService(ORDERS_SAMPLES_PATH)

    @Test
    fun `RobinhoodOrderCsvServiceTest loads from sample file`() {
        robinhoodOrderCsvService.loadAllOrdersFromFile()
    }
}
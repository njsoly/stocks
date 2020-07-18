package com.syntj.stocks

import org.junit.Assert.*
import org.junit.Test

class RobinhoodOrderCsvServiceTest : BaseUnitTest() {

    private val robinhoodOrderCsvService = RobinhoodOrderCsvService()

    @Test
    fun `RobinhoodOrderCsvServiceTest loads from sample file`() {
        robinhoodOrderCsvService.loadAllOrdersFromFile(ORDERS_SAMPLES_PATH)
    }
}
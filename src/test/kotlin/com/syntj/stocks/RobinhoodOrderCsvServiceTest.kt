package com.syntj.stocks

import com.syntj.BaseUnitTest
import org.junit.Assert.*
import org.junit.Test
import java.nio.file.Path

class RobinhoodOrderCsvServiceTest : BaseUnitTest() {

    private val robinhoodOrderCsvService = RobinhoodOrderCsvService(ORDERS_SAMPLES_PATH)

    @Test
    fun `ORDERS_SAMPLES_PATH can be parsed and exists` () {
        assertEquals(true, Path.of(ORDERS_SAMPLES_PATH).toFile().exists())
    }

    @Test
    fun `RobinhoodOrderCsvServiceTest loads from sample file`() {
        robinhoodOrderCsvService.loadAllOrdersFromFile()
    }
}

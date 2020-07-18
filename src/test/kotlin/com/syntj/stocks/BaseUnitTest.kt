package com.syntj.stocks

import org.junit.Assert.assertEquals
import org.junit.Test
import java.nio.file.Path

open class BaseUnitTest {

    companion object {
        const val TEST_DATA_DIR = "src/test/resources"
        const val ORDERS_SAMPLES_PATH = "${TEST_DATA_DIR}/orders.sample.csv"
    }

    @Test
    fun `ORDERS_SAMPLES_PATH can be parsed and exists` () {
        assertEquals(true, Path.of(ORDERS_SAMPLES_PATH).toFile().exists())
    }
}

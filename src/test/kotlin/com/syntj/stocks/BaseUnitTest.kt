package com.syntj.stocks

import org.junit.Assert.assertEquals
import org.junit.Test
import java.nio.file.Path

open class BaseUnitTest {

    companion object {
        private const val TEST_DATA_DIR = "src/test/resources"
        const val ORDERS_SAMPLES_PATH = "${TEST_DATA_DIR}/orders.sample.csv"
    }

}

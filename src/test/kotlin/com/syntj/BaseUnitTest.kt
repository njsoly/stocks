package com.syntj

import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
open class BaseUnitTest {

    companion object {
        private const val TEST_DATA_DIR = "src/test/resources"
        const val ORDERS_SAMPLES_PATH = "$TEST_DATA_DIR/orders.sample.csv"
    }

    @Before
    fun setup() {

    }

}

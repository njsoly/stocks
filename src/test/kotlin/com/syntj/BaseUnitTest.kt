package com.syntj

import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
open class BaseUnitTest {

    private val TEST_DATA_DIR = "src/test/resources"
    val ORDERS_SAMPLES_PATH = "$TEST_DATA_DIR/orders.sample.csv"

}

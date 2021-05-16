package com.syntj

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.nio.file.Files
import java.nio.file.Path

@RunWith(JUnit4::class)
open class BaseUnitTest {

    protected val TEST_DATA_DIR = "src/test/resources"
    val ORDERS_SAMPLES_PATH = "$TEST_DATA_DIR/orders.sample.csv"

    protected val objectMapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())

    fun loadTestFile(filename: String): List<String> {
        return Files.readAllLines(Path.of(TEST_DATA_DIR, filename))
    }

}

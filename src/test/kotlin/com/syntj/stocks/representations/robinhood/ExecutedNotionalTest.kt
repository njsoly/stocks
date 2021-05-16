package com.syntj.stocks.representations.robinhood

import com.syntj.BaseUnitTest
import org.junit.Assert.assertEquals
import org.junit.Test

/** Tests [ExecutedNotional] */
class ExecutedNotionalTest: BaseUnitTest() {

    private val EXAMPLE_FILENAME = "executedNotionalExample.json"

    @Test
    fun `deserialize-serialize results in same string - file`() {
        val example = loadTestFile(EXAMPLE_FILENAME).joinToString()

        val en: ExecutedNotional = objectMapper.readValue(example, ExecutedNotional::class.java)
        val str: String = objectMapper.writeValueAsString(en)

        assertEquals(false, en.amount.isBlank())
        assertEquals(false, en.currencyCode.isBlank())
        assertEquals(false, en.currencyId.isBlank())
        assertEquals(example, str)
    }
}

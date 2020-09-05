package com.syntj.stocks

import com.syntj.BaseUnitTest
import com.syntj.stocks.representations.robinhood.OrderFromCsv
import org.junit.Test
import java.time.LocalDateTime

class RobinhoodDataServiceTest : BaseUnitTest() {

    val robinhoodDataService: RobinhoodDataService = RobinhoodDataService()

    private val sampleOrders: List<OrderFromCsv> = listOf(
        OrderFromCsv("buy", "MSFT", "1.0", "200.11", LocalDateTime.now().minusDays(11), "filled")
    )

    @Test
    fun `getSymbolsFromOrders returns correctly` () {
        robinhoodDataService.getSymbolsFromOrders(sampleOrders)
        // TODO verify results
    }
}

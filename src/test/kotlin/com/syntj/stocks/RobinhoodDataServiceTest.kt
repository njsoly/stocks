package com.syntj.stocks

import com.syntj.BaseUnitTest
import com.syntj.stocks.representations.robinhood.OrderFromCsv
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import java.time.LocalDateTime

class RobinhoodDataServiceTest : BaseUnitTest() {

    @Mock
    private var robinhoodInstrumentService = mock(RobinhoodInstrumentService::class.java)

    @Mock
    private var robinhoodOrderCsvService = mock(RobinhoodOrderCsvService::class.java)

    private lateinit var robinhoodDataService: RobinhoodDataService

    @Before
    fun setup() {
        robinhoodDataService = RobinhoodDataService(robinhoodInstrumentService, robinhoodOrderCsvService)
    }


    private val sampleOrders: List<OrderFromCsv> = listOf(
        OrderFromCsv("buy", "MSFT", "1.0", "200.11", LocalDateTime.now().minusDays(11), "filled")
    )

    @Test
    fun `getSymbolsFromOrders returns correctly` () {
        robinhoodDataService.getSymbolsFromOrders(sampleOrders)
        // TODO verify results
    }
}

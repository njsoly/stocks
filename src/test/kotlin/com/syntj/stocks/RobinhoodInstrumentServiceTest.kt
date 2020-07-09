package com.syntj.stocks

import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import java.net.http.HttpClient
import java.net.http.HttpResponse

class RobinhoodInstrumentServiceTest {

    private val robinhoodInstrumentService = RobinhoodInstrumentService()

    private val msftInstrumentResponseString = "{\"id\":\"50810c35-d215-4866-9758-0ada4ac79ffa\",\"url\":\"https:\\/\\/api.robinhood.com\\/instruments\\/50810c35-d215-4866-9758-0ada4ac79ffa\\/\",\"quote\":\"https:\\/\\/api.robinhood.com\\/quotes\\/MSFT\\/\",\"fundamentals\":\"https:\\/\\/api.robinhood.com\\/fundamentals\\/MSFT\\/\",\"splits\":\"https:\\/\\/api.robinhood.com\\/instruments\\/50810c35-d215-4866-9758-0ada4ac79ffa\\/splits\\/\",\"state\":\"active\",\"market\":\"https:\\/\\/api.robinhood.com\\/markets\\/XNAS\\/\",\"simple_name\":\"Microsoft\",\"name\":\"Microsoft Corporation Common Stock\",\"tradeable\":true,\"tradability\":\"tradable\",\"symbol\":\"MSFT\",\"bloomberg_unique\":\"EQ0010174300001000\",\"margin_initial_ratio\":\"0.5000\",\"maintenance_ratio\":\"0.2500\",\"country\":\"US\",\"day_trade_ratio\":\"0.2500\",\"list_date\":\"1987-09-17\",\"min_tick_size\":null,\"type\":\"stock\",\"tradable_chain_id\":\"1ac71e01-0677-42c6-a490-1457980954f8\",\"rhs_tradability\":\"tradable\",\"fractional_tradability\":\"tradable\",\"default_collar_fraction\":\"0.05\"}"

    @Mock
    private var httpClient: HttpClient = mock(HttpClient::class.java)

    @Mock
    private var x = mock(HttpResponse::class.java)

    @Before
    fun setup() {

    }

    @Ignore
    @Test
    fun `getInstrumentStringFromUrl succeeds`() {
        whenever(x.body()).thenReturn(msftInstrumentResponseString)

        val instrumentStringFromUrl =
            robinhoodInstrumentService.getInstrumentStringFromUrl(robinhoodInstrumentService.MSFT_INSTRUMENT_URL)

        print(instrumentStringFromUrl)
    }
}
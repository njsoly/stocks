package com.syntj.stocks

class RobinhoodInstrumentService : HttpGetter() {

    companion object {
        private const val INSTRUMENT_URI_BASE = "https://api.robinhood.com/instruments"
        const val MSFT_INSTRUMENT_URL = "$INSTRUMENT_URI_BASE/50810c35-d215-4866-9758-0ada4ac79ffa/"
    }

    fun getMsftInstrument(): String {
        return getInstrumentStringFromUrl(MSFT_INSTRUMENT_URL)
    }

    /**
     * Get an instrument data JSON from Robinhood API.
     * URL should be in the form https://api.robinhood.com/instruments/<UUID>
     */
    fun getInstrumentStringFromUrl(instrumentUrl: String) : String {
        return getRequest(instrumentUrl).body() as String
    }
}

package com.syntj.stocks

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class NjStocks {

    fun run() {
        runSamples.runAll()
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(this::class.java)
        
        object runSamples {
            private val DEFAULT_STOCK_SYMBOL = WatchedStock.DBX
            
            fun requestQuoteAsString(symbol: String = DEFAULT_STOCK_SYMBOL.name) {
                logger.info("sample: FinnhubRequester().requestQuoteAsString(\"$symbol\")")

                val quoteString = FinnhubRequester().requestQuoteAsString(symbol)
                logger.info("\n\tresult: $quoteString\n***\n")

            }
            
            
            fun runAll () {
                this.requestQuoteAsString()
            }
        }
    }
}

fun main() {
    NjStocks.logger.info("░*** <NjStocks> ***░")

    NjStocks().run()

    NjStocks.logger.info("░*** </NjStocks> ***░")
}

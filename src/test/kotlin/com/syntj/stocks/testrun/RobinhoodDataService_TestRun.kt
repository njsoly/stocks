package com.syntj.stocks.testrun

import com.syntj.stocks.RobinhoodDataService

/**
 * Tests [RobinhoodDataService]
 */
fun main() {
    val robinhoodDataService = RobinhoodDataService()
    print(robinhoodDataService.getMsftInstrument())

    print(robinhoodDataService.getOrdersFromCsv())
}

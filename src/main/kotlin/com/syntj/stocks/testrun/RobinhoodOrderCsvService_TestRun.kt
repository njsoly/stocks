package com.syntj.stocks.testrun

import com.syntj.stocks.RobinhoodOrderCsvService

/**
 * Tests the key functionality of RobinhoodOrderCsvService,
 * loading up a csv file full of order data,
 * and deserializing it into [OrderFromCsv] objects.
 *
 * [main] will call run, which prints human-friendly console output and the resulting objects.
 */
class RobinhoodOrderCsvService_TestRun {

    fun run() {
        val orders = RobinhoodOrderCsvService().loadAllOrdersFromFile()
        println("**** ${javaClass.simpleName} :: printing orders from file ****")
        orders.forEach{
            println(it)
        }
        println("**** ${javaClass.simpleName} :: finished. ****")
    }
}

fun main() {
    RobinhoodOrderCsvService_TestRun().run()
}
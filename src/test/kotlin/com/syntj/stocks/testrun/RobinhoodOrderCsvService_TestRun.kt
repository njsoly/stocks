package com.syntj.stocks.testrun

import com.syntj.stocks.RobinhoodOrderCsvService
import com.syntj.stocks.representations.robinhood.OrderFromCsv

/**
 * Tests the key functionality of [RobinhoodOrderCsvService],
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

        printTotalStats(orders)
        println("**** ${javaClass.simpleName} :: finished. ****")
    }

    private fun printTotalStats(orders: List<OrderFromCsv>) {
        println("\ttotal records loaded: ${orders.size}")
        val byStatus = orders.groupBy { it.status }
        println("\torders per status: ")
        byStatus.forEach{
            println("\t\t${it.key}: ${it.value.size}")
        }
    }
}

fun main() {
    RobinhoodOrderCsvService_TestRun().run()
}
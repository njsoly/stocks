package com.syntj.stocks.testrun

import com.syntj.stocks.RobinhoodOrderCsvService
import com.syntj.stocks.representations.robinhood.OrderFromCsv
import java.time.LocalDate

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
        val bySide = orders.groupBy { it.side }
        val byWeek = orders.groupBy { LocalDate.ofYearDay(2020, (it.date.dayOfYear / 7) * 7 - 1) }
        val bySideAndStatus = orders.groupBy { "${it.side}, ${it.status}" }

        println("\torders per status: ")
        byStatus.forEach {
            println("\t\t${it.key}: ${it.value.size}")
        }

        println("\torders per side: ")
        bySide.forEach {
            println("\t\t${it.key}: ${it.value.size}")
        }

        println("\torders per week: ")
        byWeek.forEach {
            println("\t\t${it.key}: ${it.value.size}")
        }
        println("\torders per side + status: ")
        bySideAndStatus.forEach {
            println("\t\t${it.key}: ${it.value.size}")
        }
    }
}

fun main() {
    RobinhoodOrderCsvService_TestRun().run()
}
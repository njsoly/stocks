package com.syntj.stocks

import com.syntj.BaseUnitTest
import org.junit.*
import org.junit.Assert.assertEquals
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Path

class RobinhoodOrderCsvServiceTest : BaseUnitTest() {

    private val robinhoodOrderCsvService = RobinhoodOrderCsvService(ORDERS_SAMPLES_PATH)

    private val testDataFileContent = "side,symbol,shares,price,date,state\n\n" +
            "buy,TMFC,1.00000000,31.72000000,2020-08-18T20:32:55.330000Z,filled\n\n" +
            "buy,IDEX,11.00000000,1.23000000,2020-08-18T21:19:59.912000Z,filled\n\n" +
            "buy,IDEX,0.00000000,,2020-08-18T20:25:28.898000Z,cancelled\n\n" +
            "buy,VSLR,1.00000000,25.32000000,2020-08-18T20:22:55.557000Z,filled\n\n" +
            "buy,DGII,2.00000000,14.00000000,2020-08-18T18:12:58.971000Z,filled\n\n" +
            "sell,TMUS,0.00000000,,2020-08-18T17:43:47.425000Z,confirmed\n\n" +
            "sell,DGII,0.00000000,,2020-08-18T17:41:21.167000Z,confirmed\n\n" +
            "buy,IDEX,0.00000000,,2020-08-18T20:24:43.764000Z,cancelled\n\n" +
            "sell,VSLR,1.00000000,25.06000000,2020-08-18T13:57:22.775000Z,filled\n\n" +
            "sell,PG,1.00000000,136.13000000,2020-08-18T16:29:38.337000Z,filled\n\n" +
            "buy,IDEX,0.00000000,,2020-08-17T20:40:00.861000Z,cancelled\n\n" +
            "buy,VSLR,2.00000000,26.12000000,2020-08-17T17:28:36.279000Z,filled\n\n" +
            "buy,VSLR,3.00000000,26.08000000,2020-08-17T17:06:53.173000Z,filled\n\n" +
            "buy,TMUS,1.00000000,117.02000000,2020-08-17T17:06:22.472000Z,filled\n\n" +
            "buy,APHA,10.00000000,4.53800000,2020-08-17T17:05:57.997000Z,filled\n\n" +
            "buy,DGII,6.00000000,14.37500000,2020-08-17T17:05:14.151000Z,filled\n\n" +
            "buy,NIO,8.00000000,13.86630000,2020-08-17T17:04:18.597000Z,filled\n\n" +
            "buy,DBX,5.00000000,19.91000000,2020-08-17T17:00:59.946000Z,filled\n\n" +
            "sell,BAC,3.00000000,25.93330000,2020-08-17T16:59:59.311000Z,filled\n\n" +
            "sell,MSFT,1.00000000,209.67000000,2020-08-17T16:30:18.817000Z,filled\n\n" +
            "sell,DELL,2.00000000,59.97000000,2020-08-17T13:14:41.511000Z,filled\n"

    private val testDataFile: Path = Files.createFile(Path.of("${javaClass.simpleName}_test"))

    @Before
    fun setupClass () {
        Files.deleteIfExists(testDataFile)
        val writer = FileWriter(testDataFile.toFile())
        writer.write(testDataFileContent)
        writer.close()
    }

    @After
    fun tearDown () {
        Files.deleteIfExists(testDataFile)
    }

    @Test
    fun aoeu () {
        println("loading orders from ${testDataFile.fileName}")
        val result = robinhoodOrderCsvService.loadAllOrdersFromFile(testDataFile)
        assertEquals(testDataFileContent.split("\n").filter{ it.isNotBlank() }.size - 1, result.size)
    }

    @Test
    fun `ORDERS_SAMPLES_PATH can be parsed and exists` () {
        assertEquals(true, Path.of(ORDERS_SAMPLES_PATH).toFile().exists())
    }

    @Test
    fun `RobinhoodOrderCsvServiceTest loads from sample file`() {
        robinhoodOrderCsvService.loadAllOrdersFromFile()
    }

}

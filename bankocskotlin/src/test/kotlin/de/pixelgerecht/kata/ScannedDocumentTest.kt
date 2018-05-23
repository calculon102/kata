package de.pixelgerecht.kata

import java.util.*
import kotlin.collections.ArrayList
import kotlin.test.assertEquals
import org.junit.Test as test

class ScannedDocumentTest
{
    @test fun shouldParseFileWithoutEntry()
    {
        val entries = ScannedDocument("")

        assertEquals(entries.count(), 0)
    }

    @test fun shouldParseFileWithOneEntry()
    {
        val entries = ScannedDocument(TestData.D123456789.asScan)

        assertEquals(entries.count(), 1)
        assertEquals(entries.asList()[0].asString(), TestData.D123456789.asString)
    }

    @test fun shouldParseFileWithTwoEntries()
    {
        val entries = ScannedDocument(TestData.D123456789.asScan + "\n" + TestData.D987654321.asScan)

        assertEquals(entries.count(), 2)
        assertEquals(entries.asList()[0].asString(), TestData.D123456789.asString)
        assertEquals(entries.asList()[1].asString(), TestData.D987654321.asString)
    }

    @test fun shouldParseFileWithFourEntries()
    {
        val entries = ScannedDocument(TestData.D189765432.asScan + "\n" + TestData.D897654321.asScan + "\n" + TestData.D123456789.asScan + "\n" + TestData.D987654321.asScan)

        assertEquals(entries.count(), 4)
        assertEquals(entries.asList()[0].asString(), TestData.D189765432.asString)
        assertEquals(entries.asList()[1].asString(), TestData.D897654321.asString)
        assertEquals(entries.asList()[2].asString(), TestData.D123456789.asString)
        assertEquals(entries.asList()[3].asString(), TestData.D987654321.asString)
    }

    @test fun shouldParseCompleteTestData()
    {
        val file = TestData.values().map { t -> t.asScan }.reduce { s, t -> s + "\n" + t} + "\n"

        val entries = ScannedDocument(file)

        assertEquals(entries.count(), TestData.values().count())

        for (i in 0 until TestData.values().count()) {
            assertEquals(entries.asList()[i].asString(), TestData.values()[i].asString)
        }
    }

    @test fun shouldParseFileWith500RandomEntries()
    {
        val count = 500

        val expected = ArrayList<AccountNumber>(count)
        var file = ""

        for (i in 1..count) {
            val entry = createRandomEntry()

            file += entry.asScan() + "\n"
            expected.add(entry)
        }

        val parsedEntries = ScannedDocument(file)
        val actual = parsedEntries.asList()

        for (i in 0 until count) {
            assertEquals(expected[i].asString(), actual[i].asString(), "Failed entry $i")
        }
    }

    private fun createRandomEntry() : AccountNumber {
        var accountNumber = ""
        val random = Random()

        for (i in 1..9) {
            accountNumber += random.nextInt(9 - 0).toString()
        }

        return AccountNumber(accountNumber)
    }
}
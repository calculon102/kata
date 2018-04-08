package de.pixelgerecht.kata

import java.util.*
import kotlin.collections.ArrayList
import kotlin.test.assertEquals
import org.junit.Test as test

class ParsedEntriesTest
{
    @test fun shouldParseFileWithoutEntry()
    {
        val entries = ParsedEntries("")

        assertEquals(entries.count(), 0)
    }

    @test fun shouldParseFileWithOneEntry()
    {
        val entries = ParsedEntries(ParsedEntryTest.example)

        assertEquals(entries.count(), 1)
        assertEquals(entries.asList()[0].asAccountNumber(), "123456789")
    }

    @test fun shouldParseFileWithTwoEntries()
    {
        val entries = ParsedEntries(ParsedEntryTest.example + "\n" + ParsedEntryTest.reversedExample)

        assertEquals(entries.count(), 2)
        assertEquals(entries.asList()[0].asAccountNumber(), "123456789")
        assertEquals(entries.asList()[1].asAccountNumber(), "987654321")
    }

    @test fun shouldParseFileWithFourEntries()
    {
        val entries = ParsedEntries(ParsedEntryTest.example189765432 + "\n" + ParsedEntryTest.example897654321 + "\n" + ParsedEntryTest.example + "\n" + ParsedEntryTest.reversedExample)

        assertEquals(entries.count(), 4)
        assertEquals(entries.asList()[0].asAccountNumber(), "189765432")
        assertEquals(entries.asList()[1].asAccountNumber(), "897654321")
        assertEquals(entries.asList()[2].asAccountNumber(), "123456789")
        assertEquals(entries.asList()[3].asAccountNumber(), "987654321")
    }

    @test fun shouldParseFileWith500RandomEntries()
    {
        val count = 500

        val expected = ArrayList<Entry>(count)
        var file = ""

        for (i in 1..count) {
            val entry = createRandomEntry()

            file += entry.asScan() + "\n"
            expected.add(entry)
        }

        val parsedEntries = ParsedEntries(file)
        val actual = parsedEntries.asList()

        for (i in 0 until count) {
            assertEquals(expected[i].asAccountNumber(), actual[i].asAccountNumber(), "Failed entry $i")
        }
    }

    private fun createRandomEntry() : Entry {
        var accountNumber = ""
        val random = Random()

        for (i in 1..9) {
            accountNumber += random.nextInt(9 - 0).toString()
        }

        return Entry(accountNumber)
    }
}
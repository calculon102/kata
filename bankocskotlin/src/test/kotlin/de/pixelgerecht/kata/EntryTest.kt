package de.pixelgerecht.kata

import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.Test as test
import kotlin.test.assertEquals


@RunWith(Parameterized::class)
class EntryTest(private val input: String, private val expected: String) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() : List<Array<String>> {
            return listOf(
                    arrayOf("123456789", ParsedEntryTest.example),
                    arrayOf("987654321", ParsedEntryTest.reversedExample),
                    arrayOf("897654321", ParsedEntryTest.example897654321),
                    arrayOf("189765432", ParsedEntryTest.example189765432),
                    arrayOf("000000051", ParsedEntryTest.example000000051)
            )
        }
    }

    @test fun shouldRepresentInputAsEntryString() {
        val entry = Entry(input)

        assertEquals(expected, entry.asScan())
    }

    @test fun shouldKeepOriginalInput() {
        val entry = Entry(input)

        assertEquals(input, entry.asAccountNumber())
    }
}
package de.pixelgerecht.kata

import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.Test as test
import kotlin.test.assertEquals


@RunWith(Parameterized::class)
class AccountNumberTest(private val input: String, private val expected: String) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{0} -> {1}")
        fun data(): List<Array<String>> {
            return TestData.values()
                    .filter { t -> !t.isIllegal }
                    .map { t -> arrayOf(t.asString, t.asScan) }
                    .toList()
        }
    }

    @test fun shouldRepresentInputAsEntryString() {
        val entry = AccountNumber(input)

        assertEquals(expected, entry.asScan())
    }

    @test fun shouldKeepOriginalInput() {
        val entry = AccountNumber(input)

        assertEquals(input, entry.asString())
    }
}
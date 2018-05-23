package de.pixelgerecht.kata

import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.Test as test
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class ScannedAccountNumberTest(private val scan: String, private val expected: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{0} -> {1}")
        fun data(): List<Array<String>> {
            return TestData.values()
                    .filter { t -> !t.isIllegal }
                    .map { t -> arrayOf(t.asScan, t.asString) }
                    .toList()
        }
    }

    @test fun shouldParseScan() {
        assertEquals(expected, ScannedAccountNumber(scan).asString())
    }
}

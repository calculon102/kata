package de.pixelgerecht.kata

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.*
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class FindingTest(private val accountNumber: AccountNumber, private val finding: String) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{0} -> {1}")
        fun data(): List<Array<Any>> {
            val data: LinkedList<Array<Any>> = LinkedList()

            TestData.values().forEach { t ->
                val accountNumber = AccountNumber(t.asString)

                var expected = ""

                if (t.isIllegal) expected = " ILL"
                else if (!t.isValid) expected = " ERR"

                data.add(arrayOf(accountNumber, t.asString + expected))
            }

            return data
        }
    }

    @Test
    fun shouldConvertAccountNumberToFinding() {
        assertEquals(finding, Finding(accountNumber).asString())
    }
}
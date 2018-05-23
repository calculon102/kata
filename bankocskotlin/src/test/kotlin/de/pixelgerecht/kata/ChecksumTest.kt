package de.pixelgerecht.kata

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals
import kotlin.test.assertTrue


@RunWith(Parameterized::class)
class ChecksumTest(private val accountNumber: String, private val expected: Int, private val isValid: Boolean, private val isIllegal: Boolean) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{0} = {1} -> {2}")
        fun data(): List<Array<Any>> {

            val data = TestData.values()
                    .map { t -> arrayOf(t.asString, t.checksum, t.isValid, t.isIllegal) }
                    .toMutableList()
            data.add(arrayOf("12345678", 0, false, true))
            data.add(arrayOf("12345678?", 0, false, true))

            return data
        }
    }


    @Test
    fun shouldCalculateChecksum() {
        val checksum = Checksum(accountNumber)

        try {
            val actual = checksum.asInt()
            assertEquals(expected, actual)
        } catch (e: IllegalStateException) {
            assertTrue (isIllegal, "Illegal checksum detected!")
        }
    }

    @Test
    fun shouldValidateChecksum() {
        val checksum = Checksum(accountNumber)

        assertEquals(isValid, checksum.isValid())
    }
}
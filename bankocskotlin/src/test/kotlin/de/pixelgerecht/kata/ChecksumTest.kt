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
            return listOf(
                    arrayOf("000000001", 1, false, false),
                    arrayOf("000000010", 2, false, false),
                    arrayOf("000000100", 3, false, false),
                    arrayOf("000001000", 4, false, false),
                    arrayOf("000010000", 5, false, false),
                    arrayOf("000100000", 6, false, false),
                    arrayOf("001000000", 7, false, false),
                    arrayOf("010000000", 8, false, false),
                    arrayOf("100000000", 9, false, false),
                    arrayOf("100000001", 10, false, false),
                    arrayOf("100000010", 0, true, false),
                    arrayOf("100000011", 1, false, false),
                    arrayOf("000000000", 0, true, false),
                    arrayOf("111111111", 1, false, false),
                    arrayOf("222222222", 2, false, false),
                    arrayOf("333333333", 3, false, false),
                    arrayOf("444444444", 4, false, false),
                    arrayOf("555555555", 5, false, false),
                    arrayOf("666666666", 6, false, false),
                    arrayOf("777777777", 7, false, false),
                    arrayOf("888888888", 8, false, false),
                    arrayOf("999999999", 9, false, false),
                    arrayOf("123456789", 0, true, false),
                    arrayOf("12345678", 0, false, true),
                    arrayOf("12345678?", 0, false, true)
            )
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
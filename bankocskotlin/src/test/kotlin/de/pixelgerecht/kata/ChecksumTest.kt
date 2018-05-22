package de.pixelgerecht.kata

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals


@RunWith(Parameterized::class)
class ChecksumTest(private val accountNumber: String, private val expected: Int, private val isValid : Boolean) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{0} = {1} -> {2}")
        fun data(): List<Array<Any>> {
            return listOf(
                    arrayOf("000000001", 1, false),
                    arrayOf("000000010", 2, false),
                    arrayOf("000000100", 3, false),
                    arrayOf("000001000", 4, false),
                    arrayOf("000010000", 5, false),
                    arrayOf("000100000", 6, false),
                    arrayOf("001000000", 7, false),
                    arrayOf("010000000", 8, false),
                    arrayOf("100000000", 9, false),
                    arrayOf("100000001", 10, false),
                    arrayOf("100000010", 0, true),
                    arrayOf("100000011", 1, false),
                    arrayOf("000000000", 0, true),
                    arrayOf("111111111", 1, false),
                    arrayOf("222222222", 2, false),
                    arrayOf("333333333", 3, false),
                    arrayOf("444444444", 4, false),
                    arrayOf("555555555", 5, false),
                    arrayOf("666666666", 6, false),
                    arrayOf("777777777", 7, false),
                    arrayOf("888888888", 8, false),
                    arrayOf("999999999", 9, false),
                    arrayOf("123456789", 0, true)
            )
        }
    }


    @Test
    fun shouldCalculateChecksum() {
        val checksum = Checksum(accountNumber)

        assertEquals(expected, checksum.asInt())
    }

    @Test
    fun shouldValidateChecksum() {
        val checksum = Checksum(accountNumber)

        assertEquals(isValid, checksum.isValid())
    }
}
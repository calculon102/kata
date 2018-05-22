package de.pixelgerecht.kata

import java.lang.IllegalStateException

class Checksum(private val accountNumber: String) {

    fun asInt() : Int {
        if (accountNumber.length != 9) {
            throw IllegalStateException("Account number must have 9 characters for checksum-calculation: $accountNumber")
        }

        val sum = ( (accountNumber[0].toString().toInt() * 9)
                    + (accountNumber[1].toString().toInt() * 8)
                    + (accountNumber[2].toString().toInt() * 7)
                    + (accountNumber[3].toString().toInt() * 6)
                    + (accountNumber[4].toString().toInt() * 5)
                    + (accountNumber[5].toString().toInt() * 4)
                    + (accountNumber[6].toString().toInt() * 3)
                    + (accountNumber[7].toString().toInt() * 2)
                    + (accountNumber[8].toString().toInt() * 1) )

        return sum % 11
    }

    fun isValid() = asInt() == 0
}
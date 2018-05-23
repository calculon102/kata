package de.pixelgerecht.kata

/**
 * Reporting-string for a single account-number.
 */
class Finding(private val accountNumber: AccountNumber) {

    fun asString() = accountNumber.asString() + getExt()

    private fun getExt(): String {
        val checksum = Checksum(accountNumber.asString())

        return if (checksum.isIllegal()) {
            " ILL"
        } else if (!checksum.isValid()) {
            " ERR"
        } else {
            ""
        }
    }
}
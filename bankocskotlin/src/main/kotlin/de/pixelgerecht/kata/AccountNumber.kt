package de.pixelgerecht.kata

/**
 * Creates an entry for testing-purposes.
 */
class AccountNumber(private val raw: String) {
    fun asScan(): String {
        var result = ""

        for (i in 0 until raw.length) {
            result += convertLine1(raw[i])
        }

        result += "\n"

        for (i in 0 until raw.length) {
            result += convertLine2(raw[i])
        }

        result += "\n"

        for (i in 0 until raw.length) {
            result += convertLine3(raw[i])
        }

        result += "\n"

        for (i in 0 until raw.length) {
            result += convertLine4()
        }

        return result
    }

    private fun convertLine1(letter: Char): String {
        if (letter == '1' || letter == '4') {
            return "   "
        }

        return " _ "
    }

    private fun convertLine2(letter: Char): String {
        if (letter == '0') {
            return "| |"
        }

        if (letter == '1' || letter == '7') {
            return "  |"
        }

        if (letter == '2' || letter == '3') {
            return " _|"
        }

        if (letter == '5' || letter == '6') {
            return "|_ "
        }

        return "|_|"
    }

    private fun convertLine3(letter: Char): String {
        if (letter == '1' || letter == '4' || letter == '7') {
            return "  |"
        }

        if (letter == '2') {
            return "|_ "
        }

        if (letter == '3' || letter == '5' || letter == '9') {
            return " _|"
        }

        return "|_|"
    }

    private fun convertLine4(): String {
        return "   "
    }

    fun asString(): String {
        return raw
    }

    override fun toString(): String {
        return raw
    }
}

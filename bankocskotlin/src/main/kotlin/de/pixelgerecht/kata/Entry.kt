package de.pixelgerecht.kata

/**
 * Creates an entry for testing-purposes.
 */
class Entry(private val input: String) {
    fun asScan(): String {
        var result = ""

        for (i in 0 until input.length) {
            result += convertLine1(input[i])
        }

        result += "\n"

        for (i in 0 until input.length) {
            result += convertLine2(input[i])
        }

        result += "\n"

        for (i in 0 until input.length) {
            result += convertLine3(input[i])
        }

        result += "\n"

        for (i in 0 until input.length) {
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

    fun asAccountNumber(): String {
        return input
    }
}

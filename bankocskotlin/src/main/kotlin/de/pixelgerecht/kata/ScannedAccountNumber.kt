package de.pixelgerecht.kata

/**
 * Represents a single rawData of 4 lines with 27 characters each line and a single character line-break.
 */
class ScannedAccountNumber(private val rawData: String) {

    fun asString(): String {
        var result = ""

        for (i in 1..9) {
            result += parseDigit(i)
        }

        return result
    }

    private fun parseDigit(i: Int): String {
        val line1Pos = (i - 1) * 3
        val line2Pos = line1Pos + 27 + 1
        val line3Pos = line2Pos + 27 + 1

        if (rawData.length < line3Pos + 3) {
            return "?"
        }

        val line1 = rawData.substring(line1Pos, line1Pos + 3)
        val line2 = rawData.substring(line2Pos, line2Pos + 3)
        val line3 = rawData.substring(line3Pos, line3Pos + 3)

        // Could be further optimized, but more declarative this way.
        if (line1 == " _ "
         && line2 == "| |"
         && line3 == "|_|") {
            return "0"
        }

        if (line1 == "   "
         && line2 == "  |"
         && line3 == "  |") {
            return "1"
        }

        if (line1 == " _ "
         && line2 == " _|"
         && line3 == "|_ ") {
            return "2"
        }

        if (line1 == " _ "
         && line2 == " _|"
         && line3 == " _|") {
            return "3"
        }

        if (line1 == "   "
         && line2 == "|_|"
         && line3 == "  |") {
            return "4"
        }

        if (line1 == " _ "
         && line2 == "|_ "
         && line3 == " _|") {
            return "5"
        }

        if (line1 == " _ "
         && line2 == "|_ "
         && line3 == "|_|") {
            return "6"
        }

        if (line1 == " _ "
         && line2 == "  |"
         && line3 == "  |") {
            return "7"
        }

        if (line1 == " _ "
         && line2 == "|_|"
         && line3 == "|_|") {
            return "8"
        }

        if (line1 == " _ "
         && line2 == "|_|"
         && line3 == " _|") {
            return "9"
        }

        return "?"
    }

}

package de.pixelgerecht.kata.minesweeper

class SolvedTextInput(private val textInput : String)
{
    fun asString(): String {
        if (!textInput.endsWith("0 0")) {
            throw IllegalArgumentException("Input must end with '0 0'")
        }

        var curLineIndex = 0
        var curField = 1

        val lines = textInput.lineSequence().toList()
        val result = StringBuilder("")

        while (lines[curLineIndex] != "0 0") {
            val digits = lines[curLineIndex].split(" ")
            val height = Integer.parseInt(digits[0])

            val problem = lines
                    .subList(curLineIndex, curLineIndex + height + 1)
                    .joinToString(System.lineSeparator())
            val solution = Solved.forStringInput(problem)

            if (curField > 1) result.append(System.lineSeparator() + System.lineSeparator())

            result.append("Field #$curField:")
                    .append(System.lineSeparator())
                    .append(solution.asString())

            curField += 1
            curLineIndex += height + 1
        }

        return result.toString()
    }

}
package de.pixelgerecht.kata.minesweeper

import java.util.*

class Solved(private val lineCount: Int, private val colCount: Int, private val mines: Array<BooleanArray>) {
    fun asString(): String {
        val result = LinkedList<String>()

        for (y in 0 until lineCount) {
            val lineResult = StringBuilder(colCount)

            for (x in 0 until colCount) {
                val field = mines[y][x]

                when (field) {
                    true -> lineResult.append("*")
                    false -> lineResult.append(countNeighbours(y, x))
                }
            }

            result.add(lineResult.toString())
        }

        return result.joinToString(System.lineSeparator())
    }

    private fun countNeighbours(y: Int, x: Int): Int {
        return countMine(y-1, x-1) +
                countMine(y-1, x) +
                countMine(y-1, x+1) +
                countMine(y, x-1) +
                countMine(y, x+1) +
                countMine(y+1, x-1) +
                countMine(y+1, x) +
                countMine(y+1,  x+1)
    }

    private fun countMine(col: Int, line: Int) : Int {
        if (col < 0 || col >= lineCount || line < 0 || line >= colCount) {
            return 0
        }

        return if (mines[col][line]) 1 else 0
    }

    companion object {
        fun forStringInput(input : String) : Solved {
            val lines = input.lineSequence()

            if (lines.count() == 0) {
                throw IllegalArgumentException("Need at least one line!")
            }

            val firstLine = lines.first()
            val split = firstLine.split(" ")

            if (split.size != 2) {
                throw IllegalArgumentException("First line must be to digits, but is $firstLine")
            }

            val lineCount = Integer.parseInt(split[0])
            val colCount = Integer.parseInt(split[1])

            if (lineCount < 1 || lineCount > 100 || colCount < 1 || colCount > 100) {
                throw IllegalArgumentException("Number of lines and cols must be in range of 1..100, but are $lineCount x $colCount")
            }

            val sublines = lines.toList().subList(1, lines.count())

            val mines = createFieldArray(lineCount, colCount, sublines)

            return Solved(lineCount, colCount, mines)
        }

        private fun createFieldArray(lineCount: Int, colCount: Int, sublines: List<String>): Array<BooleanArray> {
            val mines = Array(lineCount) { BooleanArray(colCount) }
            for (y in 0 until lineCount) {
                for (x in 0 until colCount) {
                    val field = sublines[y][x]
                    when (field) {
                        '*' -> mines[y][x] = true
                        '.' -> mines[y][x] = false
                        else -> IllegalArgumentException("Unknown character $field")
                    }
                }
            }
            return mines
        }
    }
}
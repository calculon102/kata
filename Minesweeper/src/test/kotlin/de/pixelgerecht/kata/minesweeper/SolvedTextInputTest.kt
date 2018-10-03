package de.pixelgerecht.kata.minesweeper

import org.junit.Assert
import org.junit.Test


class SolvedTextInputTest
{
    @Test
    fun originalAcceptanceTest() {
        val actual = SolvedTextInput("4 4" + System.lineSeparator() + 
                "*..." + System.lineSeparator() +
                "...." + System.lineSeparator() +
                ".*.." + System.lineSeparator() +
                "...." + System.lineSeparator() +
                "3 5" + System.lineSeparator() +
                "**..." + System.lineSeparator() +
                "....." + System.lineSeparator() +
                ".*..." + System.lineSeparator() +
                "0 0")

        val expected = "Field #1:" + System.lineSeparator() +
                "*100" + System.lineSeparator() +
                "2210" + System.lineSeparator() +
                "1*10" + System.lineSeparator() +
                "1110" + System.lineSeparator() +
                "" + System.lineSeparator() +
                "Field #2:" + System.lineSeparator() +
                "**100" + System.lineSeparator() +
                "33200" + System.lineSeparator() +
                "1*100"

        Assert.assertEquals(expected, actual.asString())
    }

    @Test
    fun zeroSizedFieldShouldResultInEmptyString() {
        val actual = SolvedTextInput("0 0")

        val expected = ""

        Assert.assertEquals(expected, actual.asString())
    }

    @Test(expected = IllegalArgumentException::class)
    fun inputMustEndWithZeroSizedField() {
        val actual = SolvedTextInput("4 4" + System.lineSeparator() +
                "*..." + System.lineSeparator() +
                "...." + System.lineSeparator() +
                ".*.." + System.lineSeparator() +
                "...." + System.lineSeparator() +
                "3 5" + System.lineSeparator() +
                "**..." + System.lineSeparator() +
                "....." + System.lineSeparator() +
                ".*..." + System.lineSeparator())

        actual.asString()
    }

    @Test
    fun shouldSolveMinimumField() {
        val actual1 = SolvedTextInput("1 1" + System.lineSeparator() +
                "*" + System.lineSeparator() + "0 0" )

        val expected1 = "Field #1:" + System.lineSeparator() +
                "*"

        Assert.assertEquals(expected1, actual1.asString())

        val actual2 = SolvedTextInput("1 1" + System.lineSeparator() +
                "." + System.lineSeparator() + "0 0" )

        val expected2 = "Field #1:" + System.lineSeparator() +
                "0"

        Assert.assertEquals(expected2, actual2.asString())
    }

    @Test
    fun shouldSolveTwoDimensionalFields() {
        val actual1 = SolvedTextInput("2 2" + System.lineSeparator() +
                ".." + System.lineSeparator() + ".." + System.lineSeparator() + "0 0" )

        val expected1 = "Field #1:" + System.lineSeparator() +
                "00" + System.lineSeparator() + "00"

        Assert.assertEquals(expected1, actual1.asString())

        val actual2 = SolvedTextInput("2 2" + System.lineSeparator() +
                "**" + System.lineSeparator() + "**" + System.lineSeparator() + "0 0" )

        val expected2 = "Field #1:" + System.lineSeparator() +
                "**" + System.lineSeparator() + "**"

        Assert.assertEquals(expected2, actual2.asString())

        val actual3 = SolvedTextInput("2 2" + System.lineSeparator() +
                "*." + System.lineSeparator() + ".*" + System.lineSeparator() + "0 0" )

        val expected3 = "Field #1:" + System.lineSeparator() +
                "*2" + System.lineSeparator() + "2*"

        Assert.assertEquals(expected3, actual3.asString())

        val actual4 = SolvedTextInput("2 2" + System.lineSeparator() +
                ".." + System.lineSeparator() + ".*" + System.lineSeparator() + "0 0" )

        val expected4 = "Field #1:" + System.lineSeparator() +
                "11" + System.lineSeparator() + "1*"

        Assert.assertEquals(expected4, actual4.asString())
    }
}
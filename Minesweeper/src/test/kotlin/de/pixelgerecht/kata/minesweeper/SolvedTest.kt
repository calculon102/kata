package de.pixelgerecht.kata.minesweeper

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test

/**
 * TODO Test illegal arguments
 * TODO Solved does not need explicit height and width
 */
class SolvedTest
{
    @Test
    fun shouldFulfillFirstAcceptanceTest() {
        val solution = Solved.forStringInput("4 4" + System.lineSeparator() +
                "*..." +  System.lineSeparator() +
                "...." + System.lineSeparator() +
                ".*.." + System.lineSeparator() +
                "....")

        Assert.assertThat(solution.asString(), CoreMatchers.equalTo("*100" + System.lineSeparator() +
                "2210" + System.lineSeparator() +
                "1*10" + System.lineSeparator() +
                "1110"))
    }

    @Test
    fun shouldFulfillSecondAcceptanceTest() {
        val solution = Solved.forStringInput("3 5" + System.lineSeparator() +
                "**..." + System.lineSeparator() +
                "....." + System.lineSeparator() +
                ".*...")

        Assert.assertThat(solution.asString(), CoreMatchers.equalTo("**100" + System.lineSeparator() +
                "33200" + System.lineSeparator() +
                "1*100"))
    }

    @Test
    fun shouldDetectLineCount() {
        val solution = Solved.forStringInput("3 5" + System.lineSeparator() +
                "....." + System.lineSeparator() +
                "....." + System.lineSeparator() +
                ".....")

        Assert.assertThat(solution.asString().lineSequence().count(), CoreMatchers.equalTo(3))
    }
}
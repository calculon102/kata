package de.pixelgerecht.kata

import org.junit.Test
import kotlin.test.assertEquals

class LineTest {

    @Test
    internal fun calculatesScore() {
        assertEquals(0, Line(listOf(0)).getScore(), "One roll, zero pins.")
        assertEquals(1, Line(listOf(0, 1)).getScore(), "Two rolls, one pin.")

        assertEquals(
                82,
                Line(listOf(9, 0, 3, 5, 6, 1, 3, 6, 8, 1, 5, 3, 2, 5, 8, 0, 7, 1, 8, 1)).getScore(),
                "Complete game without spares and strikes."
        )

        assertEquals(12, Line(listOf(4, 6, 1, 0)).getScore(), "One spare.")
        assertEquals(33, Line(listOf(4, 6, 1, 9, 5, 2)).getScore(), "Two spares.")
        assertEquals(14, Line(listOf(0, 10, 2, 0)).getScore(), "Two spares.")
        assertEquals(10, Line(listOf(0, 10)).getScore(), "Spare, but without following rolls.")

        assertEquals(
                131,
                Line(listOf(9, 0, 3, 7, 6, 1, 3, 7, 8, 1, 5, 5, 0, 10, 8, 0, 7, 3, 8, 2, 8)).getScore(),
                "Complete game with spares."
        )

        assertEquals(24, Line(listOf(10, 6, 1)).getScore(), "One strike.")
        assertEquals(49, Line(listOf(10, 10, 1, 8)).getScore(), "Two strikes.")
        assertEquals(62, Line(listOf(10, 9, 1, 10, 3, 3)).getScore(),
                "Two strikes with one spare in between.")

        assertEquals(
                193,
                Line(listOf(10, 3, 7, 6, 1, 10, 10, 10, 2, 8, 9, 0, 7, 3, 10, 10, 10)).getScore(),
                "Complete game with strikes and spares."
        )
    }
}
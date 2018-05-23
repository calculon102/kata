package de.pixelgerecht.kata

import org.junit.Test
import kotlin.test.assertEquals

class FindingsFileTest {

    @Test
    fun shouldCreateExcpectedFileFromUserStoryExample() {
        val findings = listOf(
                Finding(AccountNumber("457508000")),
                Finding(AccountNumber("664371495")),
                Finding(AccountNumber("86110??36"))
        )

        val file = FindingsFile(findings)

        assertEquals("457508000\n" +
                "664371495 ERR\n" +
                "86110??36 ILL", file.asString())
    }
}
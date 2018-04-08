package de.pixelgerecht.kata

import org.junit.Test as test
import kotlin.test.assertEquals

class ParsedEntryTest {

    companion object {
        const val example : String =
                "    _  _     _  _  _  _  _ \n" +
                "  | _| _||_||_ |_   ||_||_|\n" +
                "  ||_  _|  | _||_|  ||_| _|\n" +
                "                           "
        const val reversedExample =
                " _  _  _  _  _     _  _    \n" +
                "|_||_|  ||_ |_ |_| _| _|  |\n" +
                " _||_|  ||_| _|  | _||_   |\n" +
                "                           "
        const val example897654321 =
                " _  _  _  _  _     _  _    \n" +
                "|_||_|  ||_ |_ |_| _| _|  |\n" +
                "|_| _|  ||_| _|  | _||_   |\n" +
                "                           "

        const val example189765432 =
                "    _  _  _  _  _     _  _ \n" +
                "  ||_||_|  ||_ |_ |_| _| _|\n" +
                "  ||_| _|  ||_| _|  | _||_ \n" +
                "                           "

        const val example000000051 =
                " _  _  _  _  _  _  _  _    \n" +
                "| || || || || || || ||_   |\n" +
                "|_||_||_||_||_||_||_| _|  |\n" +
                "                           "
    }

    @test fun shouldParseExample()
    {
        assertEquals("123456789", ParsedEntry(example).asAccountNumber())
    }

    @test fun shouldParseReversedExample()
    {
        assertEquals("987654321", ParsedEntry(reversedExample).asAccountNumber())
    }

    @test fun shouldParseExample897654321()
    {
        assertEquals("897654321", ParsedEntry(example897654321).asAccountNumber())
    }

    @test fun shouldParseExample189765432()
    {
        assertEquals("189765432", ParsedEntry(example189765432).asAccountNumber())
    }

    @test fun shouldParseExample000000051()
    {
        assertEquals("000000051", ParsedEntry(example000000051).asAccountNumber())
    }
}

package de.pixelgerecht.kata

import java.util.*

/**
 * Represents an ordered collection of ParsedEntry-instances.
 */
class ParsedEntries(private val file: String) {
    private val entryLength = ((4 * 27) + 4)

    fun count(): Int {
        if (file.isEmpty()) {
            return 0
        }

        return (file.length + 1) / entryLength
    }

    fun asList(): List<ParsedEntry> {
        val count = count()

        if (count == 0) {
            return Collections.emptyList()
        }

        val result = LinkedList<ParsedEntry>()

        for (i in 0..(count - 1)) {
            val entryBegin = entryLength * i

            result.add(ParsedEntry(file.substring(entryBegin, entryBegin + entryLength - 1)))
        }

        return result
    }

}

package de.pixelgerecht.kata

import java.util.*

/**
 * Represents an ordered collection of ScannedAccountNumber-instances.
 */
class ScannedDocument(private val rawDocument: String) {
    private val entryLength = ((4 * 27) + 4)

    fun count(): Int {
        if (rawDocument.isEmpty()) {
            return 0
        }

        return (rawDocument.length + 1) / entryLength
    }

    fun asList(): List<ScannedAccountNumber> {
        val count = count()

        if (count == 0) {
            return Collections.emptyList()
        }

        val result = LinkedList<ScannedAccountNumber>()

        for (i in 0..(count - 1)) {
            val entryBegin = entryLength * i

            result.add(ScannedAccountNumber(rawDocument.substring(entryBegin, entryBegin + entryLength - 1)))
        }

        return result
    }

}

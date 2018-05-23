package de.pixelgerecht.kata

/**
 * Concatenates an ordered list of findings as a line-separated file.
 */
class FindingsFile(private val findings: List<Finding>) {
    fun asString() = findings.map { t -> t.asString() }.reduce { s, t -> s + "\n" + t }
}
package de.pixelgerecht.kata

private const val MAX_PINS = 10
private const val MAX_FRAMES = 10

/**
 * A line of bowling with up to 10 frames.
 */
class Line(private val rolls: List<Int>) {

    fun getScore(): Int {
        var frame = 1
        var score = 0
        var isFirstFrameRoll = true

        for (i in rolls.indices) {
            if (frame > MAX_FRAMES) {
                break
            }

            score += rolls[i]

            val isStrike = isStrike(isFirstFrameRoll, i)
            val isStrikeOrSpare = isStrike || isSpare(isFirstFrameRoll, i)

            if (isStrikeOrSpare) {
                score += getRollOrZero(i + 1)
            }

            if (isStrike) {
                score += getRollOrZero(i + 2)
            } else {
                isFirstFrameRoll = !isFirstFrameRoll
            }

            if (isFirstFrameRoll) {
                frame += 1
            }
        }

        return score
    }

    private fun isSpare(isFirstFrameRoll: Boolean, rollIndex: Int) =
            !isFirstFrameRoll && rollIndex > 0 && rolls[rollIndex - 1] + rolls[rollIndex] == MAX_PINS

    private fun isStrike(isFirstFrameRoll: Boolean, rollIndex: Int) =
            isFirstFrameRoll && rolls[rollIndex] == 10

    private fun getRollOrZero(index: Int): Int =
            if (rolls.indices.last < index) 0 else rolls[index]
}
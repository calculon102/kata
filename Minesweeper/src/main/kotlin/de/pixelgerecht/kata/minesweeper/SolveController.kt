package de.pixelgerecht.kata.minesweeper

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SolveController {

    @GetMapping("/solve")
    fun solve() = SolvedTextInput("4 4" + System.lineSeparator() +
            "*..." + System.lineSeparator() +
            "...." + System.lineSeparator() +
            ".*.." + System.lineSeparator() +
            "...." + System.lineSeparator() +
            "3 5" + System.lineSeparator() +
            "**..." + System.lineSeparator() +
            "....." + System.lineSeparator() +
            ".*..." + System.lineSeparator() +
            "0 0").asString()
}
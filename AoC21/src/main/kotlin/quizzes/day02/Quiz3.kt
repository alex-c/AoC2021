package quizzes.day02

import Quiz
import quizzes.day02.Day02Utils.Companion.parseLine

class Quiz3 : Quiz {
    override fun run(verbose: Boolean) {
        val lines = FileReader.readLines("day02.txt")
        var horizontalPos = 0
        var depth = 0

        for ((index, value) in lines.withIndex()) {
            val step = parseLine(value, index)
            when (step.first) {
                Direction.forward -> horizontalPos += step.second
                Direction.down -> depth += step.second
                Direction.up -> depth -= step.second
            }
        }

        val result = horizontalPos * depth
        println("Day 02 Quiz 03 result: $result")
    }
}
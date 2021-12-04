package quizzes.day02

import Quiz
import quizzes.day02.Day02Utils.Companion.parseLine

class Quiz4 : Quiz {
    override fun run() {
        val lines = FileReader.readLines("day02.txt")
        var horizontalPos = 0
        var depth = 0
        var aim = 0

        for ((index, value) in lines.withIndex()) {
            val step = parseLine(value, index)
            when (step.first) {
                Direction.down -> aim += step.second
                Direction.up -> aim -= step.second
                Direction.forward -> {
                    horizontalPos += step.second
                    depth += aim * step.second
                }
            }
        }

        val result = horizontalPos * depth
        println("Day 02 Quiz 04 result: $result")
    }
}
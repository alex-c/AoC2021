package quizzes.day01

import Quiz

class Quiz2 : Quiz {
    override fun run() {
        val lines = FileReader.readLines("day01.txt").map { it.toInt() }
        var count = 0

        var lastValue: Int? = null

        for ((index, value) in lines.withIndex()) {
            if (index > 1) {
                val newValue = value + lines[index - 1] + lines[index - 2]
                if (lastValue != null) {
                    if (newValue > lastValue) {
                        count++;
                    }
                }
                lastValue = newValue
            }
        }

        println("Day 01 Quiz 02 result: $count")
    }
}
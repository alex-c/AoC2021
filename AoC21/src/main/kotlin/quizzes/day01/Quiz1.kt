package quizzes.day01

import Quiz

class Quiz1 : Quiz {
    override fun run() {
        val lines = FileReader.readLines("day01.txt")
        var count = 0

        var lastValue: Int? = null

        for (line in lines) {
            val newValue: Int = line.toInt();
            if (lastValue != null) {
                if (newValue > lastValue) {
                    count++;
                }
            }
            lastValue = newValue
        }

        println("Day 01 Quiz 01 result: $count")
    }
}
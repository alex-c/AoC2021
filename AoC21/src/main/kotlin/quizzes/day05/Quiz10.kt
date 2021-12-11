package quizzes.day05

import Quiz

class Quiz10 : Quiz {
    override fun run(verbose: Boolean) {
        val lines = FileReader.readLines("day05.txt")
        val map = OceanFloorInputReader.read(lines, false, verbose)

        val pointWithTwoOrMoreVents = map.getNumberOfPoints(2)

        println("Day 05 Quiz 10 result: $pointWithTwoOrMoreVents")
    }
}
package quizzes.day05

import Quiz

class Quiz9 : Quiz {
    override fun run(verbose: Boolean) {
        val lines = FileReader.readLines("day05.txt")
        val map = OceanFloorInputReader.read(lines, true, verbose)

        val pointWithTwoOrMoreVents = map.getNumberOfPoints(2)

        println("Day 05 Quiz 09 result: $pointWithTwoOrMoreVents")
    }
}
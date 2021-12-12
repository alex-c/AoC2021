package quizzes.day09

import Quiz

class Quiz17: Quiz {
    override fun run(verbose: Boolean) {
        val lines = FileReader.readLines("day09.txt")
        val map = FloorMapBuilder.build(lines)
        if (verbose) map.print()

        val lowPoints = map.findLowPoints()
        val riskLevel = lowPoints.sumOf { it.getRiskLevel() }

        println("Day 09 Quiz 17 result: $riskLevel")
    }
}
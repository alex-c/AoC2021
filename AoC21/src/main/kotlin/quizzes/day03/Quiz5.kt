package quizzes.day03

import FileReader
import Quiz

class Quiz5 : Quiz {
    override fun run(verbose: Boolean) {
        val lines = FileReader.readLines("day03.txt")
        val length = Day03Utils.validateInput(lines)

        var binaryGammaRate = ""
        var binaryEpsilonRate = ""

        for (position in 0 until length) {
            val values = Day03Utils.getPositionValues(lines, position)
            val minMax = Day03Utils.getMinMax(values)
            binaryGammaRate += minMax.second
            binaryEpsilonRate += minMax.first
        }

        println("Day 03 Quiz 05 result: ${Day03Utils.calculateResult(binaryGammaRate, binaryEpsilonRate)}")
    }
}
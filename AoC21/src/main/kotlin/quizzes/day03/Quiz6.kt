package quizzes.day03

import FileReader
import Quiz
import java.lang.Exception

class Quiz6 : Quiz {
    override fun run() {
        val lines = FileReader.readLines("day03.txt")
        val length = Day03Utils.validateInput(lines)

        var oxygenLines = lines
        var co2Lines = lines

        for (position in 0 until length) {
            oxygenLines = getOxygenGeneratorValue(oxygenLines, position)
            co2Lines = getCo2ScrubberValue(co2Lines, position)
        }

        val oxygenGeneratorRating = getResult(oxygenLines)
        val co2SScrubberRating = getResult(co2Lines)

        println("Day 03 Quiz 06 result: ${Day03Utils.calculateResult(oxygenGeneratorRating, co2SScrubberRating)}")
    }

    private fun getOxygenGeneratorValue(lines: List<String>, position: Int): List<String> {
            val values = Day03Utils.getPositionValues(lines, position)
            val minMax = Day03Utils.getMinMax(values)
            return lines.filter { it.substring(position, position + 1) == minMax.second }
    }

    private fun getCo2ScrubberValue(lines: List<String>, position: Int): List<String> {
        if (lines.size == 1) {
            return lines
        }
        val values = Day03Utils.getPositionValues(lines, position)
        val minMax = Day03Utils.getMinMax(values)
        return lines.filter { it.substring(position, position + 1) == minMax.first }
    }

    private fun getResult(resultLines: List<String>): String {
        if (resultLines.size == 1) {
            return resultLines[0]
        }
        throw Exception("More than one line left!")
    }
}
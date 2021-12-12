package quizzes.day07

import FileReader
import Quiz

class Quiz13 : Quiz {
    override fun run(verbose: Boolean) {
        val input = FileReader.readLines("day07.txt")[0].split(',').map { it.toInt() }
        val costs = mutableListOf<Int>()

        val min = input.minOf { it }
        val max = input.maxOf { it }
        if (verbose) println("Min: $min | Max: $max")

        for (i in 0..max - min) {
            val distances = input.map { if (it - min < i) i - it else it - i }
            costs.add(distances.sum())
        }

        println("Day 07 Quiz 13 costs: ${costs.minOf { it }}")
    }
}
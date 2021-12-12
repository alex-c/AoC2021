package quizzes.day07

import FileReader
import Quiz

class Quiz14 : Quiz {
    override fun run(verbose: Boolean) {
        val input = FileReader.readLines("day07.txt")[0].split(',').map { it.toInt() }
        val costs = mutableListOf<Int>()

        val min = input.minOf { it }
        val max = input.maxOf { it }

        if (verbose) {
            println("Min: $min | Max: $max")
            println("Calculating costs of ${input.size} crabs and ${max - min} positions...")
        }

        for (i in 0..max - min) {
            val distances = input.map(fun(position): Int {
                return if (position - min < i) {
                    costForDistance(i - position)
                } else if (position - min > i) {
                    costForDistance(position - i)
                } else {
                    0
                }
            })
            costs.add(distances.sumOf { it })
        }

        println("Day 07 Quiz 14 costs: ${costs.minOf { it }}")
    }

    private fun costForDistance(n: Int): Int {
        var result = 0
        for (i in 1..n) {
            result += i
        }
        return result
    }
}
package quizzes.day06

import FileReader
import Quiz

class Quiz11 : Quiz {
    override fun run(verbose: Boolean) {
        val input = FileReader.readLines("day06.txt")[0].split(',').map { it.toInt() }
        val fish = input.toMutableList()

        for (i in 0..79) {
            nextGeneration(fish)
            if (verbose) {
                println("Generation $i: ${fish.size}")
            }
        }

        println("Day 06 Quiz 11 result: ${fish.size}")
    }

    private fun nextGeneration(input: MutableList<Int>) {
        val newFish = input.count { it == 0 }
        input.mapInPlace { if (it == 0) 8 else it - 1 }
        input.addAll(MutableList(newFish) { 6 })
    }

    private fun <T> MutableList<T>.mapInPlace(transform: (T) -> T) {
        for (i in this.indices) {
            this[i] = transform(this[i])
        }
    }
}

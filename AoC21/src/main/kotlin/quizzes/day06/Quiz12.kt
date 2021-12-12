package quizzes.day06

import FileReader
import Quiz
import java.math.BigInteger

class Quiz12 : Quiz {
    override fun run(verbose: Boolean) {
        val input = FileReader.readLines("day06.txt")[0].split(',').map { it.toInt() }
        val fishCounters = initializeFishCounters(input)

        for (i in 0..255) {
            val oldCounters = fishCounters.toMap()
            for (n in 1..8) {
                fishCounters[n - 1] = oldCounters[n] ?: BigInteger.ZERO
            }
            val reproducingFish = oldCounters[0] ?: BigInteger.ZERO
            fishCounters[6] = fishCounters[6]?.plus(reproducingFish) ?: BigInteger.ZERO
            fishCounters[8] = reproducingFish
        }

        println("Day 06 Quiz 12 result: ${fishCounters.map { it.value }.sumOf { it }}")
    }

    private fun initializeFishCounters(input: List<Int>): MutableMap<Int, BigInteger> {
        return mutableMapOf(
            Pair(0, BigInteger.ZERO),
            getInitialCount(input, 1),
            getInitialCount(input, 2),
            getInitialCount(input, 3),
            getInitialCount(input, 4),
            getInitialCount(input, 5),
            getInitialCount(input, 6),
            Pair(7, BigInteger.ZERO),
            Pair(8, BigInteger.ZERO)
        )
    }

    private fun getInitialCount(input: List<Int>, n: Int): Pair<Int, BigInteger> {
        return Pair(n, BigInteger.valueOf(input.count { it == n }.toLong()))
    }
}

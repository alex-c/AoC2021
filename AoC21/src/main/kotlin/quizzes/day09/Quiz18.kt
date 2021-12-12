package quizzes.day09

import Quiz

class Quiz18: Quiz {
    override fun run(verbose: Boolean) {
        val lines = FileReader.readLines("day09.txt")
        val map = FloorMapBuilder.build(lines)

        map.findLowPoints()

        val basins = map.findBasins()
        val basinSizes = basins.map { it.size }.toMutableList()

        val top1 = basinSizes.maxOf { it }
        basinSizes.remove(top1)
        val top2 = basinSizes.maxOf { it }
        basinSizes.remove(top2)
        val top3 = basinSizes.maxOf { it }

        println("Day 09 Quiz 17 result: ${top1 * top2 * top3}")
    }
}
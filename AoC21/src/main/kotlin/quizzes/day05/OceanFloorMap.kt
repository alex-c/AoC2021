package quizzes.day05

import kotlin.math.max

class OceanFloorMap(ventLines: List<VentLine>, horizontalOnly: Boolean, verbose: Boolean) {
    private val map = ArrayList<ArrayList<Int>>()
    private var maxX: Int = 0
    private var maxY: Int = 0

    init {
        // Set map dimensions
        maxX = ventLines.maxOf { max(it.x0, it.x1) }
        maxY = ventLines.maxOf { max(it.y0, it.y1) }

        // Set up empty map
        for (x in 0..maxX) {
            map.add(ArrayList())
            for (y in 0..maxY) {
                map[x].add(0)
            }
        }

        // Populate map with lines
        for (ventLine in ventLines) {
            if (ventLine.x0 == ventLine.x1) {
                val x = ventLine.x0
                for (y in ventLine.y0 toward ventLine.y1) {
                    map[x][y] += 1
                }
            } else if (ventLine.y0 == ventLine.y1) {
                val y = ventLine.y0
                for (x in ventLine.x0 toward ventLine.x1) {
                    map[x][y] += 1
                }
            } else if (!horizontalOnly) {
                var y: Int? = null
                for (x in ventLine.x0 toward ventLine.x1) {
                    if (y == null) {
                        y = ventLine.y0
                    } else if (ventLine.y0 > ventLine.y1) {
                        y--
                    } else {
                        y++
                    }
                    map[x][y] += 1
                }
            }
        }
        if (verbose) {
            printMap()
        }
    }

    fun getNumberOfPoints(minimumNumberOfVents: Int): Int {
        var count: Int = 0
        for (x in 0..maxX) {
            for (y in 0..maxY) {
                if (map[x][y] >= minimumNumberOfVents) {
                    count++
                }
            }
        }
        return count
    }

    private infix fun Int.toward(to: Int): IntProgression {
        val step = if (this > to) -1 else 1
        return IntProgression.fromClosedRange(this, to, step)
    }

    private fun printMap() {
        for (y in 0..maxY) {
            var line = ""
            for (x in 0..maxX) {
                val value = map[x][y]
                line += if (value == 0) "." else value
            }
            println(line)
        }
    }
}
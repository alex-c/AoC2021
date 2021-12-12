package quizzes.day09

class FloorMap(private val width: Int, private val height: Int) {
    private val map: MutableList<MutableList<FloorPoint>> = ArrayList()

    init {
        for (y in 0 until height) {
            map.add(ArrayList())
            for (x in 0 until width) {
                map[y].add(FloorPoint(x, y, DEFAULT_VALUE))
            }
        }
    }

    fun get(x: Int, y: Int): FloorPoint {
        return map[y][x]
    }

    fun set(x: Int, y: Int, value: Int) {
        map[y][x] = FloorPoint(x, y, value)
    }

    fun findLowPoints(): List<FloorPoint> {
        val lowPoints = mutableListOf<FloorPoint>()
        for (y in 0 until height) {
            for (x in 0 until width) {
                val point = get(x, y)
                if (x > 0 && point.value >= getV(x - 1, y)) {
                    continue
                }
                if (x < width - 1 && point.value >= getV(x + 1, y)) {
                    continue
                }
                if (y > 0 && point.value >= getV(x, y - 1)) {
                    continue
                }
                if (y < height - 1 && point.value >= getV(x, y + 1)) {
                    continue
                }
                point.isLowPoint = true
                lowPoints.add(point)
            }
        }
        return lowPoints
    }

    fun findBasins(): List<List<FloorPoint>> {
        val basins = mutableListOf<List<FloorPoint>>()
        for (y in 0 until height) {
            for (x in 0 until width) {
                val point = get(x, y)
                if (point.isLowPoint) {
                    basins.add(getBasin(point))
                }
            }
        }
        return basins
    }

    fun print() {
        for (line in map) {
            var output = ""
            for (point in line) {
                output += point.value
            }
            println(output)
        }
    }

    private fun getV(x: Int, y: Int): Int {
        return get(x, y).value
    }

    private fun getBasin(lowPoint: FloorPoint): List<FloorPoint> {
        val basin = mutableListOf<FloorPoint>()
        lowPoint.basinDetected = true
        basin.add(lowPoint)
        var adjacentPoints = getAdjacentBasinCandidates(lowPoint)
        while (adjacentPoints.isNotEmpty()) {
            for (point in adjacentPoints) {
                point.basinDetected = true
                basin.add(point)
            }
            adjacentPoints = adjacentPoints.map { getAdjacentBasinCandidates(it) }.flatten().toSet()
        }
        return basin
    }

    private fun getAdjacentBasinCandidates(point: FloorPoint): Set<FloorPoint> {
        val adjacentPoints = mutableSetOf<FloorPoint>()
        if (point.x > 0) {
            adjacentPoints.add(get(point.x - 1, point.y))
        }
        if (point.x < width - 1) {
            adjacentPoints.add(get(point.x + 1, point.y))
        }
        if (point.y > 0) {
            adjacentPoints.add(get(point.x, point.y - 1))
        }
        if (point.y < height - 1) {
            adjacentPoints.add(get(point.x, point.y + 1))
        }
        return adjacentPoints.filter { it.value != 9 && !it.basinDetected }.toSet()
    }

    companion object {
        private const val DEFAULT_VALUE = 0
    }
}
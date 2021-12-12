package quizzes.day09

class FloorMapBuilder() {
    companion object {
        fun build(lines: List<String>): FloorMap {
            val map = FloorMap(lines[0].length, lines.size)
            for ((y, line) in lines.withIndex()) {
                val numbers = line.map { char -> Character.getNumericValue(char) }
                for ((x, number) in numbers.withIndex()) {
                    map.set(x, y, number)
                }
            }
            return map
        }
    }
}
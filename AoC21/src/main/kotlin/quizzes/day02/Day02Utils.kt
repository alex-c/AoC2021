package quizzes.day02

class Day02Utils {
    companion object {
        fun parseLine(line: String, index: Int): Pair<Direction, Int> {
            val segments: List<String> = line.split(" ");
            if (segments.size == 2) {
                val direction = Direction.valueOf(segments[0])
                val stepSize = segments[1].toInt()
                return Pair(direction, stepSize)
            }
            throw Exception("Input line $index could not be parsed: $line")
        }
    }
}
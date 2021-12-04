package quizzes.day03

class Day03Utils {
    companion object {
        fun validateInput(lines: List<String>): Int {
            if (lines.isEmpty()) {
                throw Exception("Input is empty.")
            }

            val length = lines.first().length

            if (!lines.stream().allMatch { it.length == length }) {
                throw Exception("Input lines have variable length.")
            }

            return length
        }

        fun getPositionValues(lines: List<String>, position: Int): List<String> {
            return lines.map { it.substring(position, position + 1) }
        }

        fun getMinMax(values: List<String>, preferOne: Boolean = true): Pair<String, String> {
            var zeroCount = 0
            var oneCount = 0
            for (value in values) {
                when (value) {
                    "0" -> zeroCount++
                    "1" -> oneCount++
                }
            }
            return if (zeroCount > oneCount) {
                Pair("1", "0")
            } else if (oneCount > zeroCount){
                Pair("0", "1")
            } else {
                if (preferOne) {
                    Pair("0", "1")
                } else {
                    Pair("1", "0")
                }
            }
        }

        fun calculateResult(value1: String, value2: String): Int {
            return Integer.parseInt(value1, 2) * Integer.parseInt(value2, 2)
        }
    }
}
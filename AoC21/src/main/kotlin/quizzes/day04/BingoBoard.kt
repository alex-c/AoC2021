package quizzes.day04

class BingoBoard {
    private var lastNumber: Int = 0
    private val rows = mutableListOf<List<BingoValue>>()

    fun addRow(numbers: List<Int>) {
        rows.add(numbers.map { BingoValue(it, false) })
    }

    fun draw(number: Int): Boolean {
        lastNumber = number
        for (row in rows) {
            for (value in row) {
                if (value.number == number) {
                    value.drawn = true
                }
            }
        }
        return anyLineComplete()
    }

    fun getScore(): Int {
        return lastNumber * rows.sumOf { it.sumOf { if (it.drawn) 0 else it.number } }
    }

    private fun anyLineComplete(): Boolean {
        // Check rows
        for (row in rows) {
            if (row.all { it.drawn }) {
                return true
            }
        }

        // Check columns
        val maxIndex = rows[0].size - 1
        for (i in 0..maxIndex) {
            val values = rows.map { it[i] }
            if (values.all { it.drawn }) {
                return true
            }
        }

        return false
    }
}
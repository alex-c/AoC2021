package quizzes.day04

class BingoGame(val draws: List<Int>) {
    private val boards = mutableListOf<BingoBoard>()
    private var offset = -1

    init {
        if (draws.isEmpty()) {
            throw Exception("Empty game input.")
        }
    }

    fun addBoard(board: BingoBoard) {
        boards.add(board)
    }

    fun getNumberOfBoards(): Int {
        return boards.size
    }

    fun drawNext(): List<BingoBoard> {
        val winningBoards = mutableListOf<BingoBoard>()
        offset++
        if (offset < draws.size) {
            val number = draws[offset]
            for (board in boards) {
                if (board.draw(number)) {
                    winningBoards.add(board)
                }
            }
            return winningBoards
        }
        throw Exception("No draws left.")
    }
}
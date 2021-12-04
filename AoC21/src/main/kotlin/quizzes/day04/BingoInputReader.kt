package quizzes.day04

class BingoInputReader {
    companion object {
        fun read(lines: List<String>): BingoGame {
            if (lines.isEmpty()) {
                throw Exception("Empty game input.")
            }

            // Setup board with input draws
            val draws = lines[0].split(',').map { it.toInt() }
            val game = BingoGame(draws)

            // Parse boards and add to game
            var currentBoard: BingoBoard? = null
            for (line in lines.subList(2, lines.size - 1)) {
                if (line.isEmpty()) {
                    if (currentBoard != null) {
                        game.addBoard(currentBoard)
                        currentBoard = null
                    }
                } else {
                    if (currentBoard == null) {
                        currentBoard = BingoBoard()
                    }
                    currentBoard.addRow(line.trim().split("  ", " ").map { it.toInt() })
                }
            }

            return game
        }
    }
}
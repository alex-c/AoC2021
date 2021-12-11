package quizzes.day04

import Quiz

class Quiz7: Quiz {
    override fun run(verbose: Boolean) {
        val lines = FileReader.readLines("day04.txt")
        val game = BingoInputReader.read(lines)

        var winningBoard: BingoBoard? = null
        while (winningBoard == null) {
            val winningBoards = game.drawNext()
            if (winningBoards.isNotEmpty()) {
                winningBoard = winningBoards[0]
            }
        }

        println("Day 04 Quiz 07 score:  ${winningBoard.getScore()}")
    }
}
package quizzes.day04

import Quiz

class Quiz8: Quiz {
    override fun run() {
        val lines = FileReader.readLines("day04.txt")
        val game = BingoInputReader.read(lines)

        val numberOfBoards = game.getNumberOfBoards()
        val winningBoards = mutableSetOf<BingoBoard>()
        while (winningBoards.size < numberOfBoards) {
            winningBoards.addAll(game.drawNext())
        }
        println("Day 04 Quiz 08 score: ${winningBoards.last().getScore()}")
    }
}
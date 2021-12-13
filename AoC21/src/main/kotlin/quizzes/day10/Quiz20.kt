package quizzes.day10

import FileReader
import Quiz
import java.math.BigInteger

class Quiz20 : Quiz {
    override fun run(verbose: Boolean) {
        val lines = FileReader.readLines("day10.txt")
        val tokens = Tokenizer.tokenize(lines)
        val parsingResults = mutableListOf<LineParsingResult>()

        for (line in tokens) {
            parsingResults.add(ChunkParser.parse(line))
        }

        val incompleteLines = parsingResults.filter { it.error?.type == ChunkErrorType.MISSING_CLOSING_TAG }
        val stacks = incompleteLines.map { it.error?.tokens ?: listOf() }
        val scores = stacks.map { token -> calculateScore(token) }

        val sortedScores = scores.sorted()

        println("Day 10 Quiz 20 result: ${sortedScores[sortedScores.size / 2]}")
    }

    private fun calculateScore(tokens: List<Token>): BigInteger {
        var score = BigInteger.ZERO
        for (token in tokens.reversed()) {
            score *= BigInteger.valueOf(5)
            score += mapChunkTypeToScore(token.getChunkType())
        }
        return score
    }

    private fun mapChunkTypeToScore(chunkType: ChunkType): BigInteger {
        return when (chunkType) {
            ChunkType.PARENTHESIS -> BigInteger.ONE
            ChunkType.BRACKET -> BigInteger.TWO
            ChunkType.BRACE -> BigInteger.valueOf(3)
            ChunkType.CHEVRON -> BigInteger.valueOf(4)
            else -> throw Exception("Unknown chunk type: $chunkType")
        }
    }
}
package quizzes.day10

import FileReader
import Quiz

class Quiz19 : Quiz {
    override fun run(verbose: Boolean) {
        val lines = FileReader.readLines("day10.txt")
        val tokens = Tokenizer.tokenize(lines)
        val parsingResults = mutableListOf<LineParsingResult>()

        for (line in tokens) {
            parsingResults.add(ChunkParser.parse(line))
        }

        val corruptedLines = parsingResults.filter { it.error?.type == ChunkErrorType.CHUNK_MISMATCH }
        val badTokens = corruptedLines.map { it.error?.tokens?.first { token -> token.isChunkClose() } }
        var score = 0
        for (token in badTokens) {
            score += mapChunkTypeToScore(token?.getChunkType() ?: ChunkType.UNKNOWN)
        }

        println("Day 10 Quiz 19 result: $score")
    }

    private fun mapChunkTypeToScore(chunkType: ChunkType): Int {
        return when (chunkType) {
            ChunkType.PARENTHESIS -> 3
            ChunkType.BRACKET -> 57
            ChunkType.BRACE -> 1197
            ChunkType.CHEVRON -> 25137
            else -> throw Exception("Unknown chunk type: $chunkType")
        }
    }
}
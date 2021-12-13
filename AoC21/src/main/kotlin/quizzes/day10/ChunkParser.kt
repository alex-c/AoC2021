package quizzes.day10

class ChunkParser {
    companion object {
        @JvmStatic
        fun parse(tokens: List<Token>): LineParsingResult {
            val chunkStack = ArrayDeque<Token>()
            for (token in tokens) {
                if (token.isChunkOpen()) {
                    chunkStack.add(token)
                } else if (token.isChunkClose()) {
                    if (chunkStack.isEmpty()) {
                        return LineParsingResult(ChunkError(ChunkErrorType.ORPHANED_CLOSING_TAG, listOf(token)))
                    }
                    val chunkOpen = chunkStack.removeLast()
                    if (!chunkOpen.matchesChunkType(token)) {
                        return LineParsingResult(ChunkError(ChunkErrorType.CHUNK_MISMATCH, listOf(chunkOpen, token)))
                    }
                }
            }
            if (chunkStack.isNotEmpty()) {
                return LineParsingResult(ChunkError(ChunkErrorType.MISSING_CLOSING_TAG, ArrayList(chunkStack)))
            }
            return LineParsingResult(null)
        }
    }
}
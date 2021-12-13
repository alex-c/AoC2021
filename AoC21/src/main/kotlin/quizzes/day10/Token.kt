package quizzes.day10

class Token(char: Char) {
    private var tokenType = TokenType.UNKNOWN
    private var chunkType = ChunkType.UNKNOWN

    init {
        tokenType = when (char) {
            '(', '[', '{', '<' -> TokenType.CHUNK_OPEN
            ')', ']', '}', '>' -> TokenType.CHUNK_CLOSE
            else -> throw Exception("Unknown token type: $char")
        }
        chunkType = when (char) {
            '(', ')' -> ChunkType.PARENTHESIS
            '[', ']' -> ChunkType.BRACKET
            '{', '}' -> ChunkType.BRACE
            '<', '>' -> ChunkType.CHEVRON
            else -> throw Exception("Unknown chunk type: $char")
        }
    }

    fun isChunkOpen(): Boolean {
        return tokenType == TokenType.CHUNK_OPEN
    }

    fun isChunkClose(): Boolean {
        return tokenType == TokenType.CHUNK_CLOSE
    }

    fun getChunkType(): ChunkType {
        return chunkType
    }

    fun matchesChunkType(token: Token): Boolean {
        return chunkType == token.getChunkType()
    }

    override fun toString(): String {
        return "Token($tokenType/$chunkType)"
    }
}
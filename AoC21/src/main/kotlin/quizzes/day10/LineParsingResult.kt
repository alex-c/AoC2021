package quizzes.day10

data class LineParsingResult(val error: ChunkError?) {
    fun isSuccessful(): Boolean {
        return error == null
    }
}
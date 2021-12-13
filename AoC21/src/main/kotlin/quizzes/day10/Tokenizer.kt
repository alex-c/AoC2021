package quizzes.day10

class Tokenizer {
    companion object {
        @JvmStatic
        fun tokenize(lines: List<String>): List<List<Token>> {
            val tokens = mutableListOf<MutableList<Token>>()

            for (line in lines) {
                val lineTokens = mutableListOf<Token>()
                for (char in line) {
                    lineTokens.add(Token(char))
                }
                tokens.add(lineTokens)
            }

            return tokens
        }
    }
}
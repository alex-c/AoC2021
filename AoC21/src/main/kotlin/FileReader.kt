import java.lang.Exception
import java.nio.file.Files
import java.nio.file.Path

class FileReader {
    companion object {
        fun readLines(file: String): List<String> {
            val url = this::class.java.getResource(file)
            if (url != null) {
                return Files.readAllLines(Path.of(url.toURI()));
            }
            throw Exception("Could not find file `$file`.")
        }
    }
}
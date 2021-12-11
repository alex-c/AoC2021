package quizzes.day05

class OceanFloorInputReader {
    companion object {
        fun read(lines: List<String>, horizontalOnly: Boolean, verbose: Boolean): OceanFloorMap {
            val ventLines = ArrayList<VentLine>()

            for (line in lines) {
                if (line.isNotEmpty()) {
                    val coordinates = line.split(" -> ")
                    val startPoint = coordinates[0].split(',').map { it.toInt() }
                    val endPoint = coordinates[1].split(',').map { it.toInt() }
                    ventLines.add(VentLine(startPoint[0], startPoint[1], endPoint[0], endPoint[1]))
                }
            }

            return OceanFloorMap(ventLines, horizontalOnly, verbose)
        }
    }
}
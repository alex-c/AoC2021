package quizzes.day09

class FloorPoint(val x: Int, val y: Int, val value: Int) {
    var isLowPoint = false
    var basinDetected = false
    fun getRiskLevel(): Int {
        return value + 1
    }
}
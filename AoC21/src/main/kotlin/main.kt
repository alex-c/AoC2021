import quizzes.day01.Quiz1
import quizzes.day01.Quiz2
import quizzes.day02.Quiz3
import quizzes.day02.Quiz4
import quizzes.day03.Quiz5
import quizzes.day03.Quiz6
import quizzes.day04.Quiz7
import quizzes.day04.Quiz8

fun main(args: Array<String>) {
    val quizzesToRun = args[0]
    if (quizzesToRun == "all") {
        println("Running all quizzes...")
        for (i in 1..8) {
            getQuiz(i).run()
        }
    } else {
        val quizNumber = args[0].toInt()
        println("Runing quiz $quizNumber...")
        getQuiz(quizNumber).run()
    }
}

fun getQuiz(i: Int): Quiz {
    return when (i) {
        1 -> Quiz1()
        2 -> Quiz2()
        3 -> Quiz3()
        4 -> Quiz4()
        5 -> Quiz5()
        6 -> Quiz6()
        7 -> Quiz7()
        8 -> Quiz8()
        else -> throw Exception("Quiz number $i is not implemented yet.")
    }
}
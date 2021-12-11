import quizzes.day01.Quiz1
import quizzes.day01.Quiz2
import quizzes.day02.Quiz3
import quizzes.day02.Quiz4
import quizzes.day03.Quiz5
import quizzes.day03.Quiz6
import quizzes.day04.Quiz7
import quizzes.day04.Quiz8
import quizzes.day05.Quiz10
import quizzes.day05.Quiz9
import quizzes.day06.Quiz11
import quizzes.day06.Quiz12

fun main(args: Array<String>) {
    val quizzesToRun = args[0]
    val verbose = args.size > 1 && args[1] == "-v"
    if (quizzesToRun == "all") {
        println("Running all quizzes...")
        for (i in 1..11) {
            getQuiz(i).run(verbose)
        }
    } else {
        val quizNumber = args[0].toInt()
        println("Running quiz $quizNumber...")
        getQuiz(quizNumber).run(verbose)
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
        9 -> Quiz9()
        10 -> Quiz10()
        11 -> Quiz11()
        12 -> Quiz12()
        else -> throw Exception("Quiz number $i is not implemented yet.")
    }
}
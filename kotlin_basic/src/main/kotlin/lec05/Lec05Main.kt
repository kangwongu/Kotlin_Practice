package lec05

import java.lang.IllegalArgumentException

fun main() {

}

fun validateScoreIsNotNegative(score: Int) {
    if (score < 0) {
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
    }
}

fun getPassOrFail(score: Int): String {
    // 하나의 Expression으로 처리, 삼항연산자와 유사
    return if (score >= 50) {
        "P"
    } else {
        "F"
    }
}

fun getGrade(score: Int): String {
    // 하나의 Expression으로 처리
    return if (score >= 90) {
        "A"
    } else if (score >= 80) {
        "B"
    } else if (score >= 70) {
        "C"
    } else {
        "D"
    }
}

fun validateScoreIn100(score: Int) {
    // score가 0~100에 포함되지 않으면
    if (score !in 0..100) {
        throw IllegalArgumentException("score의 범위는 0부터 100입니다")
    }
}

fun getGradeWithSwitch(score: Int): String {
    // 하나의 Expression으로 처리
    // 코틀린은 switch를 안쓰고 when을 쓴다
//    return when (score / 10) {
//        9 -> "A"
//        8 -> "B"
//        7 -> "C"
//        else -> "D"
//    }
    return when (score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber(number: Int) {
    // 여러개 조건을 동시에 검사 가능
    when (number) {
        1, 0, -1 -> println("어디서 많이 본 숫자에요~")
        else -> println("1, 0, -1이 아닙니다")
    }
}

fun judgeNumber2(number: Int) {
    when {
        number == 0 -> println("주어진 숫자는 0입니다")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다")
        else -> println("주어지는 숫자는 홀수입니다")
    }
}

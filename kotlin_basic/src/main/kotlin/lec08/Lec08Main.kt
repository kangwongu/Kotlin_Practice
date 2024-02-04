package lec08

//fun max(a: Int, b: Int): Int {
//    return if (a > b) {
//        a
//    } else {
//        b
//    }
//}

// 하나의 결과값 반환이면 block 대신 '=' 사용 가능
//fun max(a: Int, b: Int): Int =
//    if (a > b) {
//        a
//    } else {
//        b
//    }

// 추론이 가능하다면 반환 타입 생략 가능
fun max(a: Int, b: Int) = if (a > b) { a } else { b }

////////////////////////////////////////////////////////////
fun main() {
    // 두 함수는 동일한 결과
    repeat("Hello World", 3, true)
    // default parameter 활용
    repeat("Hello World")
    // named argument 적용, default parameter 값을 바꿈
    repeat("Hello World", useNewLine = false)

    ////////////////////////////////
    printAll("A", "B", "C", "D", "E")
    val array = arrayOf("A", "B", "C", "D")
    printAll(*array)    // spread 연산자, 가변인자에 넣어주기 위해
}

//fun repeat(str: String, num: Int, useNewLine: Boolean) {
//    for (i in 1..num) {
//        if (useNewLine) {
//            println(str)
//        } else {
//            println(str)
//        }
//    }
//}

// default 파라미터를 지정
fun repeat(str: String,
           num: Int = 3,
           useNewLine: Boolean = true) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            println(str)
        }
    }
}

// 가변인자
fun printAll(vararg strings: String) {
    for (string in strings) {
        println(string)
    }
}
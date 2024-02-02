package lec02

import java.lang.IllegalArgumentException

fun main() {

    println(startsWith(null))

    val str: String? = null
    // null이 들어갈 수 있는 타입은 불가
//    println(str.length)
    println(str?.length ?: 0)    // safe call, null이 아니면 실행o null이면 실행x
}

// null이 들어갈 수 없는 Boolean
fun startsWithA1(str: String?): Boolean {
    return str?.startsWith("A") ?: throw IllegalArgumentException("null No~!")
}

// null이 들어갈 수 있는 Boolean
fun startsWithA2(str: String?): Boolean? {
    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

fun startsWith(str: String?): Boolean {
    // 절대 Null이 아닌 경우 '!!'를 쓴다 (단언)
    // 근데 null이 들어오면 NPE -> null이 아닌게 확실할 때만 쓰자
    return str!!.startsWith("A")
}


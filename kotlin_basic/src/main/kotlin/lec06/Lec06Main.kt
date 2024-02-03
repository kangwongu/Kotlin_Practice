package lec06

fun main() {

    // 컬렉션 만들기, 자바의 List.of()와 유사
    val numbers = listOf(1L, 2L, 3L)

    // 자바의 향상된 for문과 유사
    for (number in numbers) {
        println(number)
    }

    // 전통적인 for문
    for (i in 1..3) {
        println(i)
    }
    // 역순
    for (i in 3 downTo 1) {
        println(i)
    }
    // 2칸씩 증가
    for (i in 1..5 step 2) {
        println(i)
    }

    // while문, 자바와 완전 동일
    var i = 1
    while (i <= 3) {
        println(i)
        i++
    }
}
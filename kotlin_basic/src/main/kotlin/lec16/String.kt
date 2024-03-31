package lec16

fun main() {
    val str = "ABC"

    // 확장함수 호출, String의 멤버 함수처럼 호출
    println(str.lastChar())
}

// 확장함수, String 클래스의 확장함수
fun String.lastChar(): Char {
    return this[this.length-1]
}


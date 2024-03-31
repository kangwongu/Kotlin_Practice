package lec15

fun main() {

    val array = arrayOf(100, 200)

    // array의 인덱스를 순회
    for (i in array.indices) {
        println("${i} ${array[i]}")
    }

    // 배열 element 추가, 코틀린에만 존재
    array.plus(300)

    // 인덱스와 value를 한 번에
    for ((idx, value) in array.withIndex()) {
        println("$idx $value")
    }
}
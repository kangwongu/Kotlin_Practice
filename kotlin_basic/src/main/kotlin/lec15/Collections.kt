package lec15

fun main() {

    // 불변 리스트
    val numbers = listOf(100, 200)
    // 공백 리스트
    val emptyList = emptyList<Int>()

    // .get으로 가져올 수도 있고, 배열처럼 []로 가져올 수도 있다
    println(numbers.get(0))
    println(numbers[0])

    // for each
    for (number in numbers) {
        println(number)
    }

    // 전통적인 for (인덱스와 value를 한꺼번에 가져올 수도 있다))
    for ((index, value) in numbers.withIndex()) {
        println("$index $value")
    }

    ////////////////
    // 가변 리스트
    val numbersInt = mutableListOf(100, 200)

    // 가변 Set
    val mutableSet = mutableSetOf(100, 200)

    // 가변 Map 초기화
    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "MONDAY"
    oldMap[2] = "TUESDAY"

    // 불변 Map 초기화
    mapOf(1 to "MONDAY", 2 to "TUESDAY")

    // key만 가져오기
    for (key in oldMap.keys) {
        println(key)
    }

    // entry(key,value) 가져오기
    for ((key, value) in oldMap.entries) {
        println("$key, $value")
    }


}
package lec01

fun main() {
    /*
    변수선언 var, val
    가변 var
    불면 val (final)
     */
    var number1 = 1L
//        var number1: Long = 1L
    number1 = 5L

    val number2 = 1L
//        number2 = 5L  에러

    // 타입? -> null 저장 가능
    var number3: Long? = 1_000L
    number3 = null

//        var number4         // 값을 안넣으면 컴파일러가 추론 불가
    var number5: Long
//        println(number5)  초기화 필요

//        val number6
    val number7: Long
//        println(number7)  초기화 필요

    /*
    TIP: 모든 변수는 우선 val로 만들고 꼭 필요한 경우 var로 변경
    코드 깔끔, 디버깅 용이
     */

    /*
    객체 인스턴스화 할 때 new를 안 붙임
     */
    val person = Person("강원구")
    println(person.name)
}
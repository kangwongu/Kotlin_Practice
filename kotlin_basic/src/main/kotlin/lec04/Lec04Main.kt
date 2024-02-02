package lec04

fun main() {

    val money1 = JavaMoney(2000L)
    val money2 = money1
    val money3 = JavaMoney(2000L)
    println(money1 === money2)  // 동일성
    println(money1 == money3)   // 동등성, 간접적으로 equals를 호출

    // 연산자 오버로딩, JavaMoney의 plus, minus 메소드 호출
    println(money1 + money3)
    println(money1 - money3)

    // compareTo를 자동호출
    if (money1 > money2) {
        println("Money1이 Money2보다 커요")
    }


}
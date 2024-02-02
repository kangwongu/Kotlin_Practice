package lec03

fun main() {
    // 형변환은 명시적으로
    val number1: Int? = 3
    val number2: Long = number1?.toLong() ?: 0L

    //////////////////////////////////////
    printAgeIfPerson(Person("", 100))
}

fun printAgeIfPerson(obj: Any?) {
    val person = obj as? Person       // as 키워드에도 ?를 붙여서 safe call
    println(person?.age)

    if (obj is Person) {              // obj가 Person 타입이면
//        val person = obj as Person  // obj를 Person 타입으로 간주 (생략가능)
        println(obj.age)              // 스마트 캐스트
    }
}
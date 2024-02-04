package lec09

fun main() {
    val person = Person("강원구", 100)
    // getter 호출
    println(person.name)
    println(person.age)
    // setter 호출
    person.age = 10
    println(person.age)

    val person1 = Person("park")
    println(person1.name)
    println(person1.age)

    println(person1.isAdult)
    println(person1.uppercaseName)
}

// 생성자, getter, setter 포함
class Person(
    val name: String,
    var age: Int
) {
    // 클래스 초기화 시점에 호출 (생성자 호출 시점)
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없어요")
        }
    }

    // 기본 생성자는 클래스 시그니처 옆에 기입하고, 추가로 존재하는 생성자는 클래스 바디에 기입
    // 부생성자는 거의 쓰지 않음
    constructor(name: String): this(name, 1)


    // 성인인지의 검증을 메소드로
//    fun isAdult(): Boolean {
//        return this.age >= 20
//    }

    // 성인인지의 검증을 프로퍼티로 (Custom Getter)
    // 객체의 필드라면 사용추천
//    val isAdult: Boolean
//        get() = this.age >= 20

    val isAdult: Boolean
        get() {
            return this.age >= 20
        }

    val uppercaseName: String
        get() = this.name.uppercase()
}
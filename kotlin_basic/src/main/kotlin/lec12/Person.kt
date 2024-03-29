package lec12

fun main() {
    Person.newBaby("A")

    ///////////////
    println(Singleton.a)
    Singleton.a += 10
    println(Singleton.a)
}

class Person(
    var name: String,
    var age: Int,
) {

    // 코틀린은 static이 없음
    // 이름을 붙여줄 수도 있다
//    companion object Factory {
    companion object {
        // 상수
        private const val MIN_AGE = 1

        // 이 어노테이션을 붙이면 static 함수를 사용하듯 바로 사용이 가능하다 (자바에서 사용 시!!)
//        @JvmStatic
        // 정적 팩토리 메소드
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }
    }

}

// object는 싱글톤 클래스를 만드는 키워드
object Singleton {
    var a: Int = 0
}
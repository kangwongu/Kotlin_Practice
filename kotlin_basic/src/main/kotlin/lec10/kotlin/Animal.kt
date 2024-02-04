package lec10.kotlin

abstract class Animal(
    protected val species: String,
    protected open val legCount: Int    // 오버라이드 할 수 있도록 해줌
) {

    abstract fun move()
}
package lec10.kotlin

class Cat(
    species: String
) : Animal(species, 4) {

    override fun move() {
        println("고양이가 사뿐사뿐")
    }
}
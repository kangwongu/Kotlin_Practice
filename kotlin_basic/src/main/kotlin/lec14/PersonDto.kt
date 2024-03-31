package lec14

fun main() {
    val dto1 = PersonDto("A", 10)
    val dto2 = PersonDto("A", 10)
    println(dto1 == dto2)
}

data class PersonDto(
    val name: String,
    val age: Int,
)
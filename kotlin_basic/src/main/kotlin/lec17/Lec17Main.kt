package lec17

import java.util.*


fun main() {
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1200),
        Fruit("사과", 1200),
        Fruit("사과", 1500),
        Fruit("바나나", 3000),
        Fruit("바나나", 3200),
        Fruit("바나나", 2500),
        Fruit("수박", 10000)
    )

    // 함수를 변수에 저장
    // 람다를 만드는 방법 1
    val isApple = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    // 함수를 변수에 저장
    // 람다를 만드는 방법 2
    val isApple2 = { fruit: Fruit -> fruit.name == "사과" }

    isApple(fruits[0])
    isApple.invoke(fruits[0])


    filterFruits(fruits, isApple)

}

// 함수를 파라미터로 받는다
//private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
//    val results = mutableListOf<Fruit>()
//    for (fruit in fruits) {
//        if (filter(fruit)) {
//            results.add(fruit)
//        }
//    }
//    return results
//}

private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    return fruits.filter(filter)
}


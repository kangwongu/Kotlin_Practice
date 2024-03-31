package lec13

fun main() {

}

class JavaHouse(
    private val address: String,
    private val livingRoom: LivingRoom,
) {
    // 중첩 클래스
//    class LivingRoom(
//        private val area: Double,
//    )

    // 권장되지 않는 중첩 클래스 선언
    inner class LivingRoom(
        private val area: Double,
    ) {
        // 바깥 클래스 참조
        val address: String
            get() = this@JavaHouse.address
    }
}
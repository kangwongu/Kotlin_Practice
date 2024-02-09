package com.group.libraryapp.domain.book

import lombok.AccessLevel
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Book (
    val name: String,

    @Enumerated(EnumType.STRING)
    val type: BookType,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어있을 수 없습니다")
        }
    }

    // 테스트 코드 작성 시, Book 객체를 만드는 fixture 메소드
    companion object {
        fun fixture(
            name: String = "책 이름",
            type: BookType = BookType.COMPUTER,
            id: Long? = null
        ): Book {
            return Book(
                name = name,
                type = type,
                id = id
            )
        }
    }
}
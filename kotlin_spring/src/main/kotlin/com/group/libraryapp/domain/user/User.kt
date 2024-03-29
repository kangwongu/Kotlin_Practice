package com.group.libraryapp.domain.user

import com.group.libraryapp.domain.book.Book
import lombok.AccessLevel
import lombok.NoArgsConstructor
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class User(
    var name: String,

    val age: Int?,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    var userLoanHistories: MutableList<UserLoanHistory> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어있을 수 없어요")
        }
    }

    fun updateName(name: String) {
        this.name = name
    }

    fun loanBook(book: Book) {
        this.userLoanHistories.add(UserLoanHistory.fixture(this, book.name))
    }

    fun returnBook(bookName: String) {
        this.userLoanHistories.first {
            history -> history.bookName == bookName
        }.doReturn()
    }

}
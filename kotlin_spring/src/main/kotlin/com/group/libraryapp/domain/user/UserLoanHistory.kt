package com.group.libraryapp.domain.user

import lombok.AccessLevel
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class UserLoanHistory(
    @ManyToOne(fetch = FetchType.LAZY)
    val user: User,

    val bookName: String,

    var status: UserLoanStatus = UserLoanStatus.LOANED,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    ) {

    fun doReturn() {
        this.status = UserLoanStatus.RETURNED
    }

    companion object {
        fun fixture(
            user: User,
            bookName: String = "뛰어라",
            status: UserLoanStatus = UserLoanStatus.LOANED,
            id: Long? = null
        ): UserLoanHistory {
            return UserLoanHistory(
                user = user,
                bookName = bookName,
                status = status,
                id = id
            )
        }
    }

}
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

    var isReturn: Boolean,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    ) {

    fun doReturn() {
        this.isReturn = true
    }

}
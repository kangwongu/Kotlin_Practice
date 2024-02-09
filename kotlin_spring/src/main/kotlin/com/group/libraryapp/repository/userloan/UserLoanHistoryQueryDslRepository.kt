package com.group.libraryapp.repository.userloan

import com.group.libraryapp.domain.user.QUserLoanHistory.userLoanHistory
import com.group.libraryapp.domain.user.UserLoanHistory
import com.group.libraryapp.domain.user.UserLoanStatus
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class UserLoanHistoryQueryDslRepository(
    private val queryFactory: JPAQueryFactory
) {

    fun find(bookName: String, status: UserLoanStatus? = null): UserLoanHistory? {
        return queryFactory
            .select(userLoanHistory)
            .from(userLoanHistory)
            .where(
                userLoanHistory.bookName.eq(bookName),
                status?.let { userLoanHistory.status.eq(status) }
            )
            .fetchOne()
    }

    fun count(status: UserLoanStatus): Long {
        return queryFactory
            .select(userLoanHistory.id.count())
            .from(userLoanHistory)
            .where(
                userLoanHistory.status.eq(status)
            )
            .fetchOne() ?: 0L
    }

}
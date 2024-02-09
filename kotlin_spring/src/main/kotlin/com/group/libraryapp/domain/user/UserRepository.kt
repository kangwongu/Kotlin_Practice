package com.group.libraryapp.domain.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface UserRepository : JpaRepository<User, Long> {

    // 코틀린은 언어 자체에서 '?'로 Null을 체크해주기 때문에, Optional이 필요없다
//    fun findByName(name: String): Optional<User>
    fun findByName(name: String): User?

    @Query("select distinct u from User u " +
            "left join fetch u.userLoanHistories ulh")
    fun findAllWithHistories(): List<User>
}
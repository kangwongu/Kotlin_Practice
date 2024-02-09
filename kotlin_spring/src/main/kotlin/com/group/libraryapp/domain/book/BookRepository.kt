package com.group.libraryapp.domain.book

import com.group.libraryapp.dto.book.response.BookStatResponse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface BookRepository : JpaRepository<Book, Long> {

    // 코틀린은 언어 자체에서 '?'로 Null을 체크해주기 때문에, Optional이 필요없다
//    fun findByName(bookName: String): Optional<Book>
    fun findByName(bookName: String): Book?

    @Query("select new com.group.libraryapp.dto.book.response.BookStatResponse(b.type, count(b.id)) " +
            "from Book b " +
            "group by b.type")
    fun getStats(): List<BookStatResponse>
}
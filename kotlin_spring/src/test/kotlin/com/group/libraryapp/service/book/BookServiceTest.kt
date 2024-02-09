package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.book.BookType
import com.group.libraryapp.domain.user.*
import com.group.libraryapp.dto.book.request.BookLoanRequest
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.dto.book.request.BookReturnRequest
import com.group.libraryapp.dto.book.response.BookStatResponse
import org.assertj.core.api.Assertions.`as`
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookServiceTest @Autowired constructor(
    private val bookService: BookService,
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository
) {

    @AfterEach
    fun afterClean() {
        bookRepository.deleteAll()
        userRepository.deleteAll()
    }

    @Test
    @DisplayName("책 등록이 정상 동작한다")
    fun saveBookTest() {
        // given
        val request = BookRequest("뛰어라", BookType.COMPUTER)

        // when
        bookService.saveBook(request)

        // then
        val result = bookRepository.findAll()
        assertThat(result).hasSize(1)
        assertThat(result[0].name).isEqualTo("뛰어라")
        assertThat(result[0].type).isEqualTo(BookType.COMPUTER)
    }

    @Test
    @DisplayName("책 대출이 정상 동작한다")
    fun loanBook() {
        // given
        bookRepository.save(Book.fixture("뛰어라"))
        val saveUser = userRepository.save(User("박지성", 45))
        val request = BookLoanRequest("박지성", "뛰어라")

        // when
        bookService.loanBook(request)

        // then
        val userLoanHistories = userLoanHistoryRepository.findAll()
        assertThat(userLoanHistories).hasSize(1)
        assertThat(userLoanHistories[0].bookName).isEqualTo("뛰어라")
        assertThat(userLoanHistories[0].user.id).isEqualTo(saveUser.id)
        assertThat(userLoanHistories[0].status).isEqualTo(UserLoanStatus.LOANED)
    }

    @Test
    @DisplayName("책이 이미 대출되어 있다면, 책 대출이 실패한다")
    fun loanBookFailTest() {
        // given
        bookRepository.save(Book.fixture("뛰어라"))
        val saveUser = userRepository.save(User("박지성", 45))
        userLoanHistoryRepository.save(UserLoanHistory.fixture(saveUser, "뛰어라"))
        val request = BookLoanRequest("박지성", "뛰어라")

        // when then
        val message = assertThrows<IllegalArgumentException> {
            bookService.loanBook(request)
        }.message
        assertThat(message).isEqualTo("이미 대출되어 있는 책이에요")
    }

    @Test
    @DisplayName("책 반납이 정상 동작한다")
    fun returnBookTest() {
        // given
        bookRepository.save(Book.fixture("뛰어라"))
        val saveUser = userRepository.save(User("박지성", 45))
        userLoanHistoryRepository.save(UserLoanHistory.fixture(saveUser, "뛰어라"))
        val request = BookReturnRequest("박지성", "뛰어라")

        // when
        bookService.returnBook(request)

        // then
        val results = userLoanHistoryRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].status).isEqualTo(UserLoanStatus.RETURNED)
    }

    @Test
    @DisplayName("책 대여 권수를 정상 확인한다")
    fun countLoanedBookTest() {
        // given
        val saveUser = userRepository.save(User("박지성", 45))
        userLoanHistoryRepository.saveAll(
            listOf(
                UserLoanHistory.fixture(saveUser, "A"),
                UserLoanHistory.fixture(saveUser, "B", UserLoanStatus.RETURNED),
                UserLoanHistory.fixture(saveUser, "C", UserLoanStatus.RETURNED),
            )
        )

        // when
        val result = bookService.countLoanedBook()

        // then
        assertThat(result).isEqualTo(1)
    }

    @Test
    @DisplayName("분야별 책 권수를 정상 확인한다")
    fun getBookStatisticsTest() {
        // given
        bookRepository.saveAll(listOf(
            Book.fixture("A", BookType.COMPUTER),
            Book.fixture("B", BookType.SCIENCE),
            Book.fixture("C", BookType.COMPUTER),
        ))

        // when
        val results = bookService.getBookStatistics()

        // then
        assertThat(results).hasSize(2)
        val computerDto = results.first { dto -> dto.type == BookType.COMPUTER }
        assertThat(computerDto.count).isEqualTo(2)

        val scienceDto = results.first { dto -> dto.type == BookType.SCIENCE }
        assertThat(scienceDto.count).isEqualTo(1)
    }
}
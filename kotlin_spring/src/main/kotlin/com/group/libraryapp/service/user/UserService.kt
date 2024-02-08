package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import com.group.libraryapp.dto.user.response.UserResponse
import com.group.libraryapp.util.fail
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    @Transactional
    fun saveUser(request: UserCreateRequest) {
        val newUser = User(request.name, request.age)
        userRepository.save(newUser)
    }

    @Transactional(readOnly = true)
    fun getUsers(): List<UserResponse> {
        return userRepository.findAll().map { user ->
            UserResponse(user)
        }
    }

    @Transactional
    fun updateUserName(request: UserUpdateRequest) {
        // 기본 JPA - findById
//        val user = userRepository.findById(request.id).orElseThrow(::IllegalArgumentException)

        // 코틀린 확장 JPA - findByIdOrNull
//        val user = userRepository.findByIdOrNull(request.id) ?: throw IllegalArgumentException()
        val user = userRepository.findByIdOrNull(request.id) ?: fail()
        user.updateName(request.name)
    }

    @Transactional
    fun deleteUser(name: String) {
//        val user = userRepository.findByName(name).orElseThrow { IllegalArgumentException() }
//        val user = userRepository.findByName(name) ?: throw IllegalArgumentException()
        val user = userRepository.findByName(name) ?: fail()
        userRepository.delete(user)
    }
}
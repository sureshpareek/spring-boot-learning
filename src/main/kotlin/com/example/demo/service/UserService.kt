package com.example.demo.service

import com.example.demo.model.User
import com.example.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository
) {

    fun getAllUsers(): List<User> = userRepository.findAll()

    fun createUser(user: User): User {
        return userRepository.save(user)
    }
}

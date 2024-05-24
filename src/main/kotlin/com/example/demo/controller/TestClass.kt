package com.example.demo.controller

import com.example.demo.dto.UserRequest
import com.example.demo.dto.UserResponse

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api")
class TestClass {

    @GetMapping("/hello")
    fun sayHello(): String {
        return "Hello, World!"
    }


    @PostMapping("/createUser")
    fun createUser(@RequestBody userRequest: UserRequest): UserResponse {
        // For simplicity, we'll just return the same data with an ID
        return UserResponse(
            id = 1L,
            name = userRequest.name,
            email = userRequest.email
        )
    }
}
package com.example.demo.dto.apiDto

import com.example.demo.dto.entities.MainUser
//data class ErrorResponse(
//    val status: Boolean,
//    val message: String,
//    val err: String
//) : ApiResponse()

data class ApiResponse<T>(
    val status: Boolean,
    val message: String? = null,
    val data: T? = null,
    val error: String? = null
)

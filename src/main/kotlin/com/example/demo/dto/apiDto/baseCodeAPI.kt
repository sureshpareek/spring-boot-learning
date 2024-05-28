package com.example.demo.dto.apiDto

import com.example.demo.dto.entities.MainUser

data class BaseUserAuthRes(val status: Boolean, val user: MainUser)
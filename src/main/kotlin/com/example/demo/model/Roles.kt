package com.example.demo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "roles")
data class Roles(
    @Id val id: String? = null,
    val roleName: String,
    val accessRights: List<String>,
    @DBRef val company: Company,
)

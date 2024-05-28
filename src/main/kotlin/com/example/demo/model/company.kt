package com.example.demo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "companies")
data class Company(
    @Id val id: String? = null,
    val companyName: String,
    val owner: String,
)

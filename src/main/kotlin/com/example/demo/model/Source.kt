package com.example.demo.model

import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "source")
data class Source(
    val sourceName: String,
    val linkUrl: String,
    @DBRef val company: Company,
)

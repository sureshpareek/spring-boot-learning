package com.example.demo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "companyusers")
data class CompanyUser(
    @Id val id: String? = null,
    val username: String,
    @DBRef val company: Company,
    @DBRef val newRole: Roles,
    val name: String,
    val email: String,
    val status: companyUserENUM,
     val employee: Employee,
)

enum class companyUserENUM {
    working ,
    stop ,
}

data class Employee(
    val KekaEmpID: String,
    val workingHours: Float,
)
package com.example.demo.repository

import com.example.demo.model.CompanyUser
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CompanyUserRepository : MongoRepository<CompanyUser, String>{
    @Query("{ 'username' : ?0, 'company' : ?1 }")
    fun findByUsernameAndCompany(username: String, company: String): CompanyUser?
}

package com.example.demo.repository

import com.example.demo.model.CompanyUser
import com.example.demo.model.Source
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SourceRepository : MongoRepository<Source, String> {
}

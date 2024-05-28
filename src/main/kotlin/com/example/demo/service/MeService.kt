package com.example.demo.service

import com.example.demo.model.CompanyUser
import com.example.demo.repository.CompanyUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MeService @Autowired constructor(
    private val companyUserRepository: CompanyUserRepository
) {

    fun findUser(username:String,company:String): CompanyUser? {
       return companyUserRepository.findByUsernameAndCompany(username,company)
    }

}

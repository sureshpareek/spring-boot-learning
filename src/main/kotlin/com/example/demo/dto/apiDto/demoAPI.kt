package com.example.demo.dto.apiDto

import com.example.demo.model.CompanyUser
import com.example.demo.model.Roles


data class MeResponse (
   val pages : List<Any>,
   val companyUser: CompanyUser,
  val  role: Roles,
)
package com.example.demo.controller

import com.example.demo.dto.apiDto.ApiResponse
import com.example.demo.dto.apiDto.MeResponse
import com.example.demo.model.Source
import com.example.demo.service.SourceService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/source/source")
class SourceController @Autowired constructor(
    private val sourceService: SourceService
) {
//    @GetMapping("createSource/{companyID}")
//    fun createSource(@RequestBody user: Source,
//        @PathVariable companyID: String, ): ResponseEntity<ApiResponse<MeResponse>> {
////val newSource = Source(sourceName = user.sourceName, linkUrl = user.linkUrl,company = companyID)
//    }
}
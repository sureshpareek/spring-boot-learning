package com.example.demo.service

import com.example.demo.model.Source
import com.example.demo.repository.SourceRepository
import org.springframework.stereotype.Service

@Service
class SourceService(
   private val sourceRepo :SourceRepository
) {
fun save(newSource:Source):Source{
    return sourceRepo.save(newSource)
}
}
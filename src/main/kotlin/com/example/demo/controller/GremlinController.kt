package com.example.demo.controller

import com.example.demo.service.GremlinService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/graph")
class GraphController(private val gremlinService: GremlinService) {

    @PostMapping("/vertex/{label}")
    fun addVertex(@RequestParam label: String, @RequestBody properties: Map<String, Any>): Map<String, Any> {
        return gremlinService.addVertex(label, properties)
    }

    @PostMapping("/edge")
    fun addEdge(
        @RequestParam fromVertexId: Any,
        @RequestParam toVertexId: Any,
        @RequestParam label: String,
        @RequestBody properties: Map<String, Any>
    ): Map<String, Any> {
        return gremlinService.addEdge(fromVertexId, toVertexId, label, properties)
    }

    @GetMapping("/vertices")
    fun findVerticesByLabel(@RequestParam label: String): List<Map<String, Any>> {
        return gremlinService.findVerticesByLabel(label)
    }

    // Add more endpoints as needed
}

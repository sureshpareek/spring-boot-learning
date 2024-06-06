package com.example.demo.controller

import com.example.demo.service.GremlinResponseParser
import com.example.demo.service.GremlinService
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/gremlin")
class GremlinController(private val gremlinService: GremlinService,private val gremlinResponseParser: GremlinResponseParser) {

    data class VertexRequest(val label: String, val properties: Map<String, Any>)
    data class VertexResponse(val data: String)

    @PostMapping("/addVertex", consumes = ["application/json"], produces = ["application/json"])
    fun addVertex(@RequestBody vertexRequest: VertexRequest): ResponseEntity<VertexResponse> {
        val result = gremlinService.addVertex(vertexRequest.label, vertexRequest.properties)
        return ResponseEntity.ok(VertexResponse(result))
    }

    data class VertexQueryRequest(val label: String, val propertyKey: String, val propertyValue: String)

    @PostMapping("/getVertex", consumes = ["application/json"], produces = ["application/json"])
    fun getVertex(@RequestBody vertexQueryRequest: VertexQueryRequest): Any {
        val result = gremlinService.getVertexByProperty(vertexQueryRequest.label, vertexQueryRequest.propertyKey, vertexQueryRequest.propertyValue)
        return  result
    }
}

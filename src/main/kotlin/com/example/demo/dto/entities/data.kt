package com.example.demo.dto.entities

data class Vertex(
    val id: String,
    val label: String,
    val properties: Map<String, Any>
)

data class Edge(
    val id: String,
    val label: String,
    val fromVertexId: String,
    val toVertexId: String,
    val properties: Map<String, Any>
)

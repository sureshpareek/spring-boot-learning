package com.example.demo.service

import org.apache.tinkerpop.gremlin.driver.Client
import org.apache.tinkerpop.gremlin.driver.Result
import org.springframework.stereotype.Service

@Service
class GremlinService(private val gremlinClient: Client) {

    fun executeGremlinQuery(query: String): List<Map<String, Any>> {
        val results: List<Result> = gremlinClient.submit(query).all().get()
        return results.map { result ->
            val obj = result.getObject()
            when (obj) {
                is Map<*, *> -> obj as Map<String, Any>
                else -> mapOf("value" to obj)
            }
        }
    }

    fun addVertex(label: String, properties: Map<String, Any>): Map<String, Any> {
        val query = buildString {
            append("graph.addVertex(label, '").append(label).append("'")
            properties.forEach { (key, value) ->
                append(", '").append(key).append("', '").append(value).append("'")
            }
            append(")")
        }
        return executeGremlinQuery(query).firstOrNull() ?: emptyMap()
    }

    fun addEdge(fromVertexId: Any, toVertexId: Any, label: String, properties: Map<String, Any> = emptyMap()): Map<String, Any> {
        val query = buildString {
            append("g.V($fromVertexId).addE('$label').to(g.V($toVertexId))")
            properties.forEach { (key, value) ->
                append(".property('$key', '$value')")
            }
        }
        return executeGremlinQuery(query).firstOrNull() ?: emptyMap()
    }

    fun findVerticesByLabel(label: String): List<Map<String, Any>> {
        val query = "g.V().hasLabel('$label')"
        return executeGremlinQuery(query)
    }
}

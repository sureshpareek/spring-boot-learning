package com.example.demo.service

import org.apache.tinkerpop.gremlin.driver.Client
import org.springframework.stereotype.Service

@Service
class GremlinService(private val gremlinClient: Client) {

    fun addVertex(label: String, properties: Map<String, Any>): String {
        val query = StringBuilder("g.addV('$label')")
        properties.forEach { (key, value) ->
            query.append(".property('$key', '$value')")
        }
//        return query.toString()
        val result = gremlinClient.submit(query.toString()).all().get()
        return result.toString()
    }

    fun getVertexByProperty(label: String, propertyKey: String, propertyValue: String): String {
        val query = "g.V().hasLabel('$label').has('$propertyKey', '$propertyValue').valueMap(true)"
        val result = gremlinClient.submit(query).all().get()
        return result.toString()
    }
}

package com.example.demo.service

import org.apache.tinkerpop.gremlin.driver.Client
import org.apache.tinkerpop.gremlin.driver.Result
import org.apache.tinkerpop.gremlin.structure.io.graphson.GraphSONMapper
import org.apache.tinkerpop.gremlin.structure.io.graphson.GraphSONWriter
import org.springframework.stereotype.Service
import java.io.StringWriter
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
@Service
class GremlinService(private val gremlinClient: Client) {

    private val objectMapper = ObjectMapper()

    fun addVertex(label: String, properties: Map<String, Any>): String {
        val query = StringBuilder("g.addV('$label')")
        properties.forEach { (key, value) ->
            query.append(".property('$key', '$value')")
        }
        val result = gremlinClient.submit(query.toString()).all().get()
        return result.toString()
    }

    fun getVertexByProperty(label: String, propertyKey: String, propertyValue: String): String {
        val query = "g.V().hasLabel('$label').valueMap(true)"
        val result = gremlinClient.submit(query).all().get()


        val processedResult = result.map { it.getObject() as Map<String, Any> }
            .map { unwrapSingleValueArrays(it) }

        val objectMapper = jacksonObjectMapper()
        return objectMapper.writeValueAsString(processedResult)
    }

    fun unwrapSingleValueArrays(map: Map<String, Any>): Map<String, Any> {
        return map.mapValues { (_, value) ->
            (if (value is List<*> && value.size == 1) value[0] else value)!!
        }
    }



}

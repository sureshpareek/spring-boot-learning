package com.example.demo.service
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class GremlinResponseParser {

    private val logger = LoggerFactory.getLogger(GremlinResponseParser::class.java)
   private val mapper = jacksonObjectMapper()

    fun parseGremlinResponse(response: String): Any {
        return try {
            val cleanedResponses = if (response.startsWith("[")) {
                // Handle array of objects
                response
                    .substring(1, response.length - 1)  // Remove outer array brackets
                    .split("}, result").map {
                        cleanAndParse(it.trimStart(',', ' ', 'r', 'e', 's', 'u', 'l', 't'))
                    }
            } else {
                // Handle single object
                listOf(cleanAndParse(response))
            }
    cleanedResponses
//            mapper.readValue(cleanedResponses.toString())
        } catch (e: Exception) {
            logger.error("Failed to parse Gremlin response", e)
//            emptyMap()
            response
        }

    }

    private fun cleanAndParse(response: String): String {
        var cleanedResponse = response
            .replace("=", ":")
            .replace("result{object:{", "")
            .replace("{object:", "")
            .replace("class:java.util.LinkedHashMap", "")
            .replace("}}", "}}")
            .replace("} }", "}")
            .replace("[", "'")
            .replace("]", "'")
            .replace(", ", ",")

        // Ensure keys are properly quoted
        cleanedResponse = cleanedResponse.replace("([a-zA-Z0-9]+):".toRegex()) { matchResult ->
            val key = matchResult.groupValues[1]
            "'$key':"
        }

        // Ensure values are properly quoted
        cleanedResponse = cleanedResponse.replace(":([a-zA-Z]+)".toRegex()) { matchResult ->
            val value = matchResult.groupValues[1]
            ":'$value'"
        }

        // Remove leading and trailing braces
        if(cleanedResponse[0] == '"'){
            cleanedResponse = cleanedResponse.substring(1, cleanedResponse.length - 1)
        }
        return cleanedResponse
    }
}

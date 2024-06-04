package com.example.demo.config

import org.apache.tinkerpop.gremlin.driver.Client
import org.apache.tinkerpop.gremlin.driver.Cluster
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GremlinConfig {

    @Value("\${gremlin.server.host}")
    private lateinit var gremlinHost: String

    @Value("\${gremlin.server.port}")
    private lateinit var gremlinPort: String

    @Bean
    fun gremlinClient(): Client {
        val cluster = Cluster.build()
            .addContactPoint(gremlinHost)
            .port(Integer.parseInt(gremlinPort))
            .serializer(org.apache.tinkerpop.gremlin.driver.ser.GraphSONMessageSerializerV3d0())
//            .serializer(org.apache.tinkerpop.gremlin.driver.ser.GraphSONMessageSerializerV1d0())
            .create()
        return cluster.connect()
    }
}

package com.example.demo.config

import org.apache.tinkerpop.gremlin.driver.Cluster
import org.apache.tinkerpop.gremlin.driver.Client
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GremlinConfig {

    @Value("\${gremlin.uri}")
    lateinit var uri: String

    @Value("\${gremlin.port}")
    var port: Int = 7687  // Default Bolt port

    @Value("\${gremlin.username}")
    lateinit var username: String

    @Value("\${gremlin.password}")
    lateinit var password: String

    @Bean
    fun gremlinCluster(): Cluster {
        return Cluster.build()
            .addContactPoint(uri)
            .port(port)
            .credentials(username, password) // Enable SSL
            .create()
    }

    @Bean
    fun gremlinClient(cluster: Cluster): Client {
        return cluster.connect()
    }
}

package com.example.demo.security

//import com.example.demo.security.CustomAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.reactive.function.client.WebClient

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {

        http
            .authorizeHttpRequests { authorizeRequests ->
                authorizeRequests.anyRequest().permitAll() // Allow all requests
            }
            .csrf { csrf -> csrf.disable() } // Disable CSRF protection
        return http.build()


//        http
//            .csrf { it.disable() }
//            .authorizeHttpRequests { auth -> auth.anyRequest().authenticated() }
//            .addFilterBefore(customAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
//        return http.build()
    }

//    @Bean
//    fun customAuthenticationFilter(webClient: WebClient): CustomAuthenticationFilter {
//        return CustomAuthenticationFilter(webClient)
//    }

    @Bean
    fun webClient(): WebClient {
        return WebClient.builder().build()
    }
}

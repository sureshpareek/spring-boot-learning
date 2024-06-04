package com.example.demo.security

import com.example.demo.dto.apiDto.BaseUserAuthRes
import com.example.demo.dto.entities.MainUser
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono

@Component
class CustomAuthenticationFilter(private val webClient: WebClient) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        try {
            val ssid = request.getHeader("ssid")
            val key = request.getHeader("key")
            val token = request.getHeader("token")

            if (ssid != null && key != null && token != null) {
                val authResponse = authenticate(ssid, key, token).block()

                if (authResponse?.status == true) {
                    val user = User(authResponse.user.username, "", emptyList())
                    val auth = UsernamePasswordAuthenticationToken(user, null, user.authorities)
                    auth.details = WebAuthenticationDetailsSource().buildDetails(request)
                    SecurityContextHolder.getContext().authentication = auth
                    request.setAttribute("authResponse", authResponse) // Store the AuthResponse in the request attribute
                } else {
                    throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized")
                }
            }
            chain.doFilter(request, response)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized", e)
        }
    }

    private fun authenticate(ssid: String, key: String, token: String): Mono<BaseUserAuthRes> {
        return webClient.get()
            .uri("https://portal.codeperts.com/user-api-authentication")
            .header("ssid", ssid)
            .header("key", key)
            .header("token", token)
            .retrieve()
            .bodyToMono(BaseUserAuthRes::class.java)
    }



}

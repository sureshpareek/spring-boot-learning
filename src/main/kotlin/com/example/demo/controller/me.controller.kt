package com.example.demo.controller

import com.example.demo.AccessRightsData
import com.example.demo.dto.apiDto.ApiResponse
import com.example.demo.dto.apiDto.BaseUserAuthRes
import com.example.demo.dto.apiDto.MeResponse
import com.example.demo.model.CompanyUser
import com.example.demo.service.MeService
import com.example.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.ErrorResponse

@RestController
@RequestMapping("/source/me")
class MeController @Autowired constructor(
    private val meService: MeService
) {

    @GetMapping("getPages/{companyID}")
    fun getPages(request: HttpServletRequest,   @PathVariable companyID: String,): ResponseEntity<ApiResponse<MeResponse>> {
        val authResponse = request.getAttribute("authResponse") as BaseUserAuthRes
       val userInformation =  meService.findUser(authResponse.user.username,companyID)
        if(userInformation == null || userInformation.newRole == null){
            return  ResponseEntity.badRequest().body(
                ApiResponse(
                    status = false,
                    message = "No Role here",
                    error = "Do not have any role to work on this module"
                ))
        }


        val filteredArray = AccessRightsData.accessRights.filter { role -> userInformation.newRole.accessRights.contains(role.name.value)}

        if(filteredArray != null && filteredArray[0] != null){
            return  ResponseEntity.badRequest().body(
                ApiResponse(
                    status = true,
                    data = MeResponse(pages = filteredArray[0].frontPage, companyUser = userInformation, role = userInformation.newRole),               ))
        }else{
            return  ResponseEntity.badRequest().body(
                ApiResponse(
                    status = false,
                    message = "No Role here",
                    error = "Do not have any role to work on this module"
                ))
        }

    }
}

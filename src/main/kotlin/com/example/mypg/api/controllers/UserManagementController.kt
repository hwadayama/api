package com.example.mypg.api.controllers

import com.example.mypg.api.`interface`.request.LoginRequest
import com.example.mypg.api.`interface`.request.UserListRequest
import com.example.mypg.api.`interface`.response.UserInfoResponse
import com.example.mypg.api.`interface`.response.UserResponse
import com.example.mypg.api.services.UserService
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

// Swagger UI
// http://localhost:8082/swagger-ui/
@RestController
@RequestMapping("/userApi")
class UserManagementController(
    private val useService: UserService
) {

    @ApiOperation("MYユーザ取得")
    @ResponseBody
    @PostMapping("/login")
    fun getMyUser(
            @Valid
            @RequestBody request: LoginRequest
    ): ResponseEntity<UserResponse> {

        return useService.getMyUser(request.userId, request.password)
    }

    @ApiOperation("ユーザリスト取得")
    @ResponseBody
    @PostMapping("/userList")
    fun getUserList(
            @Valid
            @RequestBody request: UserListRequest
    ): ResponseEntity<UserInfoResponse> {

        return useService.getUserList(request.limit, request.offset)
    }
}
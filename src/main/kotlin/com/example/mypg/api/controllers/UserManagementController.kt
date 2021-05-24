package com.example.mypg.api.controllers

import com.example.mypg.api.`interface`.request.LoginRequest
import com.example.mypg.api.`interface`.request.UserListRequest
import com.example.mypg.api.`interface`.responce.UserResponce
import com.example.mypg.api.usecases.UserUseCase
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

// Swagger UI
// http://localhost:8082/swagger-ui/
@RestController
@RequestMapping("/userApi")
class UserManagementController(
    private val useCase: UserUseCase
) {

    @ApiOperation("MYユーザ取得")
    @ResponseBody
    @PostMapping("/login")
    fun getMyUser(
            @Valid
            @RequestBody request: LoginRequest
    ): ResponseEntity<UserResponce> {

        return useCase.getMyUser(request.userId, request.password)
    }

    @ApiOperation("ユーザリスト取得")
    @ResponseBody
    @PostMapping("/userList")
    fun getUserList(
            @Valid
            @RequestBody request: UserListRequest
    ): ResponseEntity<List<UserResponce>> {

        return useCase.getUserList(request.limit, request.offset)
    }
}
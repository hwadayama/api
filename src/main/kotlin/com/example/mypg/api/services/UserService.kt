package com.example.mypg.api.services

import com.example.mypg.api.`interface`.response.UserInfoResponse
import com.example.mypg.api.`interface`.response.UserResponse
import com.example.mypg.api.repositorys.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository
) {

    fun getMyUser(userId:String,password:String): ResponseEntity<UserResponse> {
        return repository.getMyUser(userId,password)
    }

    fun getUserList(limit:Long,offset:Long):ResponseEntity<UserInfoResponse>{
        return repository.getUserList(limit,offset)
    }
}
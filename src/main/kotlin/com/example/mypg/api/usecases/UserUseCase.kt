package com.example.mypg.api.usecases

import com.example.mypg.api.`interface`.responce.UserResponce
import com.example.mypg.api.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class UserUseCase(
    private val service: UserService
) {

    fun getMyUser(userId:String,password:String): ResponseEntity<UserResponce> {
        return service.getMyUser(userId,password)
    }
    fun getUserList(limit:Long,offset:Long):ResponseEntity<List<UserResponce>>{
        return service.getUserList(limit,offset)
    }
}
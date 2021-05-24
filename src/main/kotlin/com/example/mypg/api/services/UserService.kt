package com.example.mypg.api.services

import com.example.mypg.api.`interface`.responce.UserResponce
import com.example.mypg.api.repositorys.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository
) {

    fun getMyUser(userId:String,password:String): ResponseEntity<UserResponce> {
        return repository.getMyUser(userId,password)
    }

    fun getUserList(limit:Long,offset:Long):ResponseEntity<List<UserResponce>>{
        return repository.getUserList(limit,offset)
    }
}
package com.example.mypg.api.repositorys

import com.example.mypg.api.`interface`.response.UserResponce
import com.example.mypg.api.dto.UserDto
import com.example.mypg.api.exception.MyException
import com.example.mypg.api.mapper.UserMapper
import com.example.mypg.api.messages.Messages.Companion.MESSAGE_NOT_FOUND
import com.example.mypg.api.messages.Messages.Companion.MESSAGE_SERVER_ERROR
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import java.lang.RuntimeException

@Repository
class UserRepository(
    private val mapper: UserMapper
) {

    fun getMyUser(userId: String, password: String): ResponseEntity<UserResponce> {

        try{
            val dto = mapper.getMyUser(userId, password)
            if (dto == null){
                throw MyException(HttpStatus.NOT_FOUND.value(),MESSAGE_NOT_FOUND)
            }
            val response = UserResponce(
                    userid = dto.userid,
                    password = dto.password,
                    name = dto.name,
                    mailaddress = dto.mailaddress,
                    zipcode = dto.zipcode,
                    address1 = dto.address1,
                    address2 = dto.address2,
                    address3 = dto.address3,
                    telno = dto.telno,
                    authority = dto.authority,
                    insdate = dto.insdate,
                    upddate = dto.upddate
            )
            return ResponseEntity.ok(response)
        }catch (e:RuntimeException){
            throw MyException(HttpStatus.INTERNAL_SERVER_ERROR.value(),MESSAGE_SERVER_ERROR)
        }

    }

    fun getUserList(limit: Long, offset: Long): ResponseEntity<List<UserResponce>> {

        val response = mutableListOf<UserResponce>()
        val dtos:List<UserDto> = mapper.getUserList(limit, offset)

        try{
            for (data in dtos){
                val userData = UserResponce(
                        userid = data.userid,
                        password = data.password,
                        name = data.name,
                        mailaddress = data.mailaddress,
                        zipcode = data.zipcode,
                        address1 = data.address1,
                        address2 = data.address2,
                        address3 = data.address3,
                        telno = data.telno,
                        authority = data.authority,
                        insdate = data.insdate,
                        upddate = data.upddate
                )
                response.add(userData)
            }
        }catch (e:RuntimeException){
            throw MyException(HttpStatus.INTERNAL_SERVER_ERROR.value(),MESSAGE_SERVER_ERROR)
        }
        return ResponseEntity.ok(response)
    }
}
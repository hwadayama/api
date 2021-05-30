package com.example.mypg.api.repositorys

import com.example.mypg.api.`interface`.response.OtherInfo
import com.example.mypg.api.`interface`.response.UserInfoResponse
import com.example.mypg.api.`interface`.response.UserResponse
import com.example.mypg.api.dto.UserDto
import com.example.mypg.api.exception.MyException
import com.example.mypg.api.mapper.FoundRowsMapper
import com.example.mypg.api.mapper.UserMapper
import com.example.mypg.api.messages.Messages.Companion.MESSAGE_SERVER_ERROR
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import java.lang.RuntimeException

@Repository
class UserRepository(
    private val mapper: UserMapper,
    private val foundRowMapper: FoundRowsMapper
) {

    fun getMyUser(userId: String, password: String): ResponseEntity<UserResponse> {

        try{
            val dto = mapper.getMyUser(userId, password)
            val response = UserResponse(
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

    fun getUserList(limit: Long, offset: Long): ResponseEntity<UserInfoResponse> {

        val response = mutableListOf<UserResponse>()
        val dtos:List<UserDto> = mapper.getUserList(limit, offset)

        try{
            for (data in dtos){
                val userData = UserResponse(
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

            val foundRow = foundRowMapper.getFoundRows()
            val otherInfo = OtherInfo(limit,offset,foundRow.row)
            val userInfo = UserInfoResponse(response,otherInfo)

            return ResponseEntity.ok(userInfo)
        }catch (e:RuntimeException){
            throw MyException(HttpStatus.INTERNAL_SERVER_ERROR.value(),MESSAGE_SERVER_ERROR)
        }

    }
}
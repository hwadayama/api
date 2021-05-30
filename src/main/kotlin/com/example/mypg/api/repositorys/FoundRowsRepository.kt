package com.example.mypg.api.repositorys

import com.example.mypg.api.`interface`.response.FoundRows
import com.example.mypg.api.exception.MyException
import com.example.mypg.api.mapper.FoundRowsMapper
import com.example.mypg.api.messages.Messages.Companion.MESSAGE_NOT_FOUND
import com.example.mypg.api.messages.Messages.Companion.MESSAGE_SERVER_ERROR
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import java.lang.RuntimeException

@Repository
class FoundRowsRepository(
    private val mapper: FoundRowsMapper
) {

    fun getFoundRows():ResponseEntity<FoundRows>{
        try{
            val dto = mapper.getFoundRows()
            if (dto == null){
                throw MyException(HttpStatus.NOT_FOUND.value(),MESSAGE_NOT_FOUND)
            }
            val response = FoundRows(
                    row = dto.row
            )
            return ResponseEntity.ok(response)
        }catch (e:RuntimeException){
            throw MyException(HttpStatus.INTERNAL_SERVER_ERROR.value(),MESSAGE_SERVER_ERROR)
        }
    }
}
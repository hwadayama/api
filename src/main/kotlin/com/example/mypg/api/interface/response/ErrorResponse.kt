package com.example.mypg.api.`interface`.response

import com.example.mypg.api.exception.MyException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ErrorResponse(var message: String) {
    companion object {
        fun createResponse(e: MyException): ResponseEntity<ErrorResponse> {
            return when (e.status) {
                404 -> ResponseEntity<ErrorResponse>(ErrorResponse(e.errorMessage), HttpStatus.NOT_FOUND)
                else -> ResponseEntity<ErrorResponse>(ErrorResponse(e.errorMessage), HttpStatus.INTERNAL_SERVER_ERROR)
            }

        }
    }
}
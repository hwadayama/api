package com.example.mypg.api.exception

import com.example.mypg.api.`interface`.response.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
@Component
class RequestExceptionHandler {
    /**
     * BadRequestExceptionのハンドラー
     */
    @ExceptionHandler(MyException::class)
    fun getBadRequestException(req: HttpServletRequest, error: MyException): ResponseEntity<ErrorResponse> {
        return ErrorResponse.createResponse(error);
    }
}
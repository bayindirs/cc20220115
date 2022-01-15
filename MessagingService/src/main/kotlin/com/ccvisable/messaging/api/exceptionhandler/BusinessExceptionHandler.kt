package com.ccvisable.messaging.api.exceptionhandler

import com.ccvisable.messaging.api.model.ErrorInfo
import com.ccvisable.messaging.exception.BusinessException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class BusinessExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun handle(exception: BusinessException): ErrorInfo {
        return ErrorInfo(exception.message ?: "Business Exception message is empty")
    }

}
package com.destiny.investment.api.exceptions

import org.springframework.http.HttpStatus

class DestinyException(val eCause: ExceptionCause, val errorDescription: String? = null): Exception(eCause.toString())

enum class ExceptionCause(val status: HttpStatus) {
    WrongFileType(HttpStatus.BAD_REQUEST),
    FileTooBig(HttpStatus.BAD_REQUEST),
    Unauthorized(HttpStatus.UNAUTHORIZED),
    UnableToSendMail(HttpStatus.INTERNAL_SERVER_ERROR)
}
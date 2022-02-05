package com.destiny.investment.api.exceptions

import com.destiny.investment.api.configuration.IConfiguration
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MaxUploadSizeExceededException
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver
import org.springframework.web.servlet.view.json.MappingJackson2JsonView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


val kLogger = KotlinLogging.logger { }
/**
 * Global exception handler that is responsible for handling exceptions thrown during
 * api calls.
 * This handler will (should at least) always return a readable exception to the user, not exposing
 * sensitive data.
 * Exception are also internationalized or at least should be through the [DestinyException].
 *
 * Finally, exceptions are thrown with the JSON format, keeping the [HttpStatus] set in every [DestinyException].
 * If the exception isn't an exception that has been handled by the services, then, a default error message is returned.
 */
@Component
class ExceptionHandler(
    private val configuration: IConfiguration,
    @Value("\${spring.servlet.multipart.max-file-size}") private val maxFileSize: String
): AbstractHandlerExceptionResolver() {

    override fun doResolveException(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any?,
        ex: Exception
    ): ModelAndView? {
        kLogger.error(ex) { "Error caught" }

        val (errCode, err) = when (ex) {
            is DestinyException -> ex.eCause.status to ex.errorDescription
            is MaxUploadSizeExceededException -> HttpStatus.BAD_REQUEST to exceptions.file_too_big(maxFileSize, LocaleContextHolder.getLocale())
            else -> HttpStatus.INTERNAL_SERVER_ERROR to exceptions.unknown_error(configuration.mail.mainMail, LocaleContextHolder.getLocale())
        }

        return ModelAndView().apply {
            status = errCode
            view = MappingJackson2JsonView().apply {
                setAttributesMap(mapOf(
                    "error" to err
                ))
            }
        }
    }

}
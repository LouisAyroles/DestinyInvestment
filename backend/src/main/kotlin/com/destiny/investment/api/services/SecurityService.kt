package com.destiny.investment.api.services

import com.destiny.investment.api.exceptions.DestinyException
import com.destiny.investment.api.exceptions.ExceptionCause
import exceptions
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.util.HtmlUtils.htmlEscape

@Service
class SecurityService {

    fun ensurePDFFile(file: MultipartFile): MultipartFile {
        if (file.contentType != "application/pdf") {
            throw DestinyException(
                eCause = ExceptionCause.WrongFileType,
                errorDescription = exceptions.wrong_file_format(".pdf", LocaleContextHolder.getLocale())
            )
        }

        return file
    }

    fun escapeHtml(str: String): String {
        return htmlEscape(str)
    }

}
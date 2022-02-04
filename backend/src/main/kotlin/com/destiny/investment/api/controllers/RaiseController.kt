package com.destiny.investment.api.controllers

import com.destiny.investment.api.dto.PartialRaiseForm
import com.destiny.investment.api.dto.completeWithPDF
import com.destiny.investment.api.dto.toMailContent
import com.destiny.investment.api.services.MailService
import com.destiny.investment.api.services.SecurityService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("api/raise", produces = [MediaType.APPLICATION_JSON_VALUE])
class RaiseController(
    private val mailService: MailService,
    private val securityService: SecurityService
) {

    @PostMapping("apply", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun uploadForm(@RequestPart raiseForm: PartialRaiseForm, @RequestPart pitchDeck: MultipartFile) {
        mailService.sendMail(
            content = raiseForm.completeWithPDF(
                pitchDeck = securityService.ensurePDFFile(pitchDeck)
            ).toMailContent()
        )
    }

}
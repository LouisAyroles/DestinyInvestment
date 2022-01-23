package com.destiny.investment.api.controllers

import com.destiny.investment.api.dto.InvestForm
import com.destiny.investment.api.dto.toMailContent
import com.destiny.investment.api.services.MailService
import com.destiny.investment.api.services.SecurityService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/invest", produces = [MediaType.APPLICATION_JSON_VALUE])
class InvestController(
    private val mailService: MailService,
    private val securityService: SecurityService
) {

    @PostMapping("apply")
    fun uploadForm(@RequestBody form: InvestForm) {
        mailService.sendMail(form.toMailContent())
    }

}
package com.destiny.investment.api.dto

import com.destiny.investment.api.dto.mails.IMailContent
import com.destiny.investment.api.dto.mails.RaiseMailContent
import org.springframework.web.multipart.MultipartFile

interface IRaiseFormBase {
    val email: String
    val name: String
    val companyName: String
}

data class PartialRaiseForm (
    override val email: String,
    override val name: String,
    override val companyName: String,
): IRaiseFormBase

data class CompleteRaiseForm(
    override val email: String,
    override val name: String,
    override val companyName: String,
    val pitchDeck: MultipartFile
): IRaiseFormBase

fun PartialRaiseForm.completeWithPDF(pitchDeck: MultipartFile) = CompleteRaiseForm(
    email = email,
    name = name,
    companyName = companyName,
    pitchDeck = pitchDeck
)

fun CompleteRaiseForm.toMailContent(): IMailContent = RaiseMailContent(this)
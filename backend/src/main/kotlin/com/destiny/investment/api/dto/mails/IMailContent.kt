package com.destiny.investment.api.dto.mails

import org.springframework.web.multipart.MultipartFile

interface IMailContent {
    val content: String
    val subject: String
    val files: List<MultipartFile>
}
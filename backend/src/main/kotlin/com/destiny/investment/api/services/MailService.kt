package com.destiny.investment.api.services

import com.destiny.investment.api.configuration.ServerConfiguration
import com.destiny.investment.api.dto.mails.IMailContent
import com.destiny.investment.api.exceptions.DestinyException
import com.destiny.investment.api.exceptions.ExceptionCause
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import javax.mail.MessagingException

@Service
class MailService(
    private val mailSender: JavaMailSender,
    private val configuration: ServerConfiguration
) {

    fun sendMail(content: IMailContent) {
        val message = mailSender.createMimeMessage()
        try {
            MimeMessageHelper(message, true).run {
                content.files.forEach { attachment ->
                    addAttachment(
                        attachment.originalFilename ?: attachment.name,
                        attachment
                    )
                }

                setSubject(content.subject)
                setText(content.content)
                setTo(configuration.mail.to.toTypedArray())
            }

            mailSender.send(message)
        } catch (e: MessagingException) {
            throw DestinyException(
                eCause = ExceptionCause.UnableToSendMail,
                errorDescription = exceptions.unable_to_send_mail(configuration.mail.mainMail, LocaleContextHolder.getLocale())
            )
        }
    }

}
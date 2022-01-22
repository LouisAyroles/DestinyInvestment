package com.destiny.investment.api.services

import com.destiny.investment.api.configuration.IConfiguration
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
    private val configuration: IConfiguration
) {

    /**
     * Sends a mail with the information provided by the [content].
     * Configuration to send mail is fetched from the global application's configuration.
     * For more information, see the
     * [default configuration][com.destiny.investment.api.configuration.BeanConfiguration.configuration].
     *
     * If it's impossible to send the mail, an exception will be thrown.
     * It should be handled by the global Exception handler though.
     *
     * @param content content to send in this mail.
     */
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
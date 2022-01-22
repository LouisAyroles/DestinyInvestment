package com.destiny.investment.api.configuration

import com.sksamuel.hoplite.ConfigLoader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.io.File
import java.util.*
import javax.mail.Authenticator
import javax.mail.PasswordAuthentication
import javax.mail.Session

@Configuration
@EnableWebMvc
class BeanConfiguration {

    private val configFileLocation by lazy {
        val os = System.getProperty("os.name").lowercase()

        when {
            os.startsWith("win", ignoreCase = true) -> "${System.getenv("APPDATA")}/destiny/config.yaml"
            else -> "/etc/destiny/config.yaml"
        }
    }

    private val mailSession get() = Session.getDefaultInstance(
        Properties().apply { putAll(configuration.mail.auth) },
        object : Authenticator() {
            override fun getPasswordAuthentication() = PasswordAuthentication(
                configuration.mail.credentials.username,
                configuration.mail.credentials.password
            )
        }
    )

    @get:Bean
    val mailSender get(): JavaMailSender = JavaMailSenderImpl().apply {
        session = mailSession
    }

    @get:Bean
    val configuration: IConfiguration = ConfigLoader().loadConfigOrThrow<ServerConfigurationProperties>(File(configFileLocation))

}
package com.destiny.investment.api.configuration

import com.sksamuel.hoplite.ConfigLoader
import mu.KotlinLogging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import java.io.File
import java.util.*
import javax.mail.Authenticator
import javax.mail.PasswordAuthentication
import javax.mail.Session

private val logger = KotlinLogging.logger {  }
@Configuration
//@EnableWebMvc
class BeanConfiguration {

    /**
     * Configuration file location that is parametrized
     * given the os on which the server is running.
     * By default, the os is considered to be Linux.
     */
    private val configFileLocation by lazy {
        val os = System.getProperty("os.name").lowercase()

        when {
            os.startsWith("win", ignoreCase = true) -> "${System.getenv("APPDATA")}/destiny/config.yaml"
            else -> "/etc/destiny/config.yaml"
        }.also {
            logger.info { "OS is '$os', loading configuration from '$it'" }
        }
    }

    /**
     * Mail session configured from the provided [configuration]
     */
    private val mailSession get() = Session.getDefaultInstance(
        Properties().apply { putAll(configuration.mail.auth) },
        object : Authenticator() {
            override fun getPasswordAuthentication() = PasswordAuthentication(
                configuration.mail.credentials.username,
                configuration.mail.credentials.password
            )
        }
    )

    /**
     * Default mail sender configured with proper session to authenticated
     * to the SMTP server.
     * Configuration is fetched from configuration file.
     * For more information, see [configuration]
     */
    @get:Bean
    val mailSender get(): JavaMailSender = JavaMailSenderImpl().apply {
        session = mailSession
    }


    /**
     * Configuration extracted from the configuration file.
     */
    @get:Bean
    val configuration: IConfiguration = ConfigLoader().loadConfigOrThrow<ServerConfiguration>(File(configFileLocation))

}
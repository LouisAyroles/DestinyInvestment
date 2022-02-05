package com.destiny.investment.api.configuration

import java.nio.file.Path

interface IConfiguration {
    val mail: Mail
}

data class ServerConfiguration(
    override val mail: Mail,
): IConfiguration

data class Credentials(
    val username: String,
    val password: String
)

data class Mail(
    val to: List<String>,
    val mainMail: String,
    val credentials: Credentials,
    val auth: Map<String, String>
)
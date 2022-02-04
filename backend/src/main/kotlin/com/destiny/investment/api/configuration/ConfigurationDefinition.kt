package com.destiny.investment.api.configuration

import java.nio.file.Path

interface IConfiguration {
    val mail: Mail
    val server: Server
}

data class ServerConfiguration(
    override val mail: Mail,
    override val server: Server
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

data class Server(
    val staticFilesLocation: String,
    val staticFilesUrlBase: String
)
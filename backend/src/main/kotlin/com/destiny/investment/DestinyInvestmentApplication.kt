package com.destiny.investment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.logging.LogLevel
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import java.io.OutputStream
import java.io.PrintStream
import java.lang.StringBuilder

@SpringBootApplication
class DestinyInvestmentApplication: SpringBootServletInitializer() {

    fun loggerOutputStream(level: LogLevel) = object: OutputStream() {
        private val builder = StringBuilder()
        private val log: (String) -> Unit by lazy {
            when (level) {
                LogLevel.ERROR -> logger::error
                else -> logger::info
            }
        }

        override fun write(b: Int) {
            val asChar = b.toChar()

            if (asChar == '\n' || asChar == '\r') {
                if (builder.isNotEmpty()) {
                    log(builder.toString())
                    builder.clear()
                }
            } else {
                builder.append(asChar)
            }
        }
    }

    override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder {
        System.setOut(PrintStream(loggerOutputStream(LogLevel.INFO)))
        System.setErr(PrintStream(loggerOutputStream(LogLevel.ERROR)))
        return builder.sources(DestinyInvestmentApplication::class.java)
    }
}

fun main(args: Array<String>) {
    runApplication<DestinyInvestmentApplication>(*args)
}

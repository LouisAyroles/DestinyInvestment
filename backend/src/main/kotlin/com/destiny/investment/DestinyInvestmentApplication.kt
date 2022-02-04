package com.destiny.investment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class DestinyInvestmentApplication: SpringBootServletInitializer() {
    override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder {
        return builder.sources(DestinyInvestmentApplication::class.java)
    }
}

fun main(args: Array<String>) {
    runApplication<DestinyInvestmentApplication>(*args)
}

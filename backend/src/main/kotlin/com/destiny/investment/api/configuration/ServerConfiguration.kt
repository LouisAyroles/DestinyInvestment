package com.destiny.investment.api.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class ServerConfiguration(@Autowired private val configuration: IConfiguration): IConfiguration by configuration
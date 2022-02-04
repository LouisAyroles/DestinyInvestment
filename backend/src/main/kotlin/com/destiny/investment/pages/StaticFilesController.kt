package com.destiny.investment.pages

import com.destiny.investment.api.configuration.IConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebMvc
class StaticFilesController(
    private val configuration: IConfiguration
): WebMvcConfigurer {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler(configuration.server.staticFilesUrlBase)
            .addResourceLocations(configuration.server.staticFilesLocation)
    }

}
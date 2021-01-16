package io.mickeckemi21.masteringspring5bookexamples.stockchangecloud.simpleloggingtask.task

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.cloud.task.configuration.EnableTask
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.text.SimpleDateFormat
import java.util.*

@EnableTask
@Configuration(proxyBeanMethods = false)
class SimpleTaskConfig {

    private val logger = LoggerFactory.getLogger(SimpleTaskConfig::class.java)

    @Bean
    fun commandLineRunner() = CommandLineRunner { args ->
        logger.info("Task execution: ${SimpleDateFormat().format(Date())}")
    }

}

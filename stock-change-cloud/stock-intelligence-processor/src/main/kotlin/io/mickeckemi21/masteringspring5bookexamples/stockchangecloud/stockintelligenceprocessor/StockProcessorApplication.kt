package io.mickeckemi21.masteringspring5bookexamples.stockchangecloud.stockintelligenceprocessor

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.messaging.converter.KotlinSerializationJsonMessageConverter
import org.springframework.messaging.converter.MessageConverter

@SpringBootApplication
class StockIntelligenceProcessorApplication {

//    @Bean
//    fun jsonMessageConverter(): MessageConverter = KotlinSerializationJsonMessageConverter()

}

fun main(args: Array<String>) {
    runApplication<StockIntelligenceProcessorApplication>(*args)
}

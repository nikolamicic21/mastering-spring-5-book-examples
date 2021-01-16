package io.mickeckemi21.masteringspring5bookexamples.stockchangecloud.simpleloggingtask

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleLoggingTaskApplication

fun main(args: Array<String>) {
    runApplication<SimpleLoggingTaskApplication>(*args)
}

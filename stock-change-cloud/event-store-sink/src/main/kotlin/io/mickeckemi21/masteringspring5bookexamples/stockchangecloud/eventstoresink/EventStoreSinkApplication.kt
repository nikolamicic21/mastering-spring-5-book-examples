package io.mickeckemi21.masteringspring5bookexamples.stockchangecloud.eventstoresink

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EventStoreSinkApplication

fun main(args: Array<String>) {
    runApplication<EventStoreSinkApplication>(*args)
}

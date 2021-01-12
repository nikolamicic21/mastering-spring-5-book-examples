package io.mickeckemi21.masteringspring5bookexamples.stockchangecloud.eventstoresink.sink

import io.mickeckemi21.masteringspring5bookexamples.stockchangecloud.stockmodel.model.StockPriceChangeEventWithHoldings
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.stereotype.Component

@Slf4j
@Component
@EnableBinding(Sink::class)
class EventStoreSink {

    private val logger = LoggerFactory.getLogger(EventStoreSink::class.java)

    @StreamListener(Sink.INPUT)
    fun loggerSink(event: StockPriceChangeEventWithHoldings) {
        logger.info("sink received: $event")
    }

}

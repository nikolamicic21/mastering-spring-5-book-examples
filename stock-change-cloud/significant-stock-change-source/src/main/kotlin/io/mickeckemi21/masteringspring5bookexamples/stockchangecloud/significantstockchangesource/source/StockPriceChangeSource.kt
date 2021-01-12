package io.mickeckemi21.masteringspring5bookexamples.stockchangecloud.significantstockchangesource.source

import io.mickeckemi21.masteringspring5bookexamples.stockchangecloud.stockmodel.model.StockPriceChangeEvent
import io.mickeckemi21.masteringspring5bookexamples.stockchangecloud.stockmodel.model.StockTicker
import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.messaging.Source
import org.springframework.integration.annotation.InboundChannelAdapter
import org.springframework.integration.annotation.Poller
import org.springframework.integration.core.MessageSource
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
@EnableBinding(Source::class)
class StockPriceChangeSource {

    private val logger = LoggerFactory.getLogger(StockPriceChangeSource::class.java)

    @InboundChannelAdapter(
        value = Source.OUTPUT,
        poller = [
            Poller(fixedDelay = "5000", maxMessagesPerPoll = "1")
        ]
    )
    fun stockPriceChangeEvent(): Message<StockPriceChangeEvent> {
        val event = StockPriceChangeEvent()
        event.stockTicker = StockTicker.values().random().name
        event.oldPrice = BigDecimal((10..20).random())
        event.newPrice = BigDecimal((10..20).random())

        logger.info("source sent: $event")

        return MessageBuilder.withPayload(event).build()
    }

}

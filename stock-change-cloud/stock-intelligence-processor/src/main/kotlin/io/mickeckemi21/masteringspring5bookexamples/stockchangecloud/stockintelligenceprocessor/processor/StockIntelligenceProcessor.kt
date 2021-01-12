package io.mickeckemi21.masteringspring5bookexamples.stockchangecloud.stockintelligenceprocessor.processor

import io.mickeckemi21.masteringspring5bookexamples.stockchangecloud.stockmodel.model.StockPriceChangeEvent
import io.mickeckemi21.masteringspring5bookexamples.stockchangecloud.stockmodel.model.StockPriceChangeEventWithHoldings
import io.mickeckemi21.masteringspring5bookexamples.stockchangecloud.stockmodel.model.StockTicker
import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Processor
import org.springframework.integration.annotation.Transformer
import org.springframework.integration.support.MessageBuilder
import org.springframework.messaging.Message
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Component

@Component
@EnableBinding(Processor::class)
open class StockIntelligenceProcessor {

    private val logger = LoggerFactory.getLogger(StockIntelligenceProcessor::class.java)

    companion object {
        val HOLDINGS = mapOf(
            StockTicker.FACEBOOK to 10,
            StockTicker.GOOGLE to 0,
            StockTicker.IBM to 15,
            StockTicker.MICROSOFT to 30,
            StockTicker.TWITTER to 50,
        )
    }

    @Transformer(
        inputChannel = Processor.INPUT,
        outputChannel = Processor.OUTPUT
    )
    fun addOurInventory(@Payload event: StockPriceChangeEvent): Message<StockPriceChangeEventWithHoldings> {
        val holding = HOLDINGS[StockTicker.valueOf(event.stockTicker)]!!
        logger.info("processor received: $event")
        val eventWithHoldings = StockPriceChangeEventWithHoldings()
        eventWithHoldings.apply {
            stockTicker = event.stockTicker
            oldPrice = event.oldPrice
            newPrice = event.newPrice
            holdings = holding
        }
        logger.info("processor sent: $eventWithHoldings")

        return MessageBuilder.withPayload(eventWithHoldings).build()
    }

}

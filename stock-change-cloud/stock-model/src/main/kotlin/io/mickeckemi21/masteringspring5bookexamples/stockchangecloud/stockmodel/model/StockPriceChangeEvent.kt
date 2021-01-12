package io.mickeckemi21.masteringspring5bookexamples.stockchangecloud.stockmodel.model

import java.io.Serializable
import java.math.BigDecimal

open class StockPriceChangeEvent : Serializable {
    lateinit var stockTicker: String
    lateinit var oldPrice: BigDecimal
    lateinit var newPrice: BigDecimal

    override fun toString(): String =
        "StockPriceChangeEvent - " +
                "stockTicker: $stockTicker, " +
                "oldPrice: $oldPrice, " +
                "newPrice: $newPrice"
}

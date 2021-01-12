package io.mickeckemi21.masteringspring5bookexamples.stockchangecloud.stockmodel.model

import java.io.Serializable

class StockPriceChangeEventWithHoldings : StockPriceChangeEvent(), Serializable {

    var holdings: Int? = null

    override fun toString(): String = "${super.toString()}, holdings: $holdings"

}

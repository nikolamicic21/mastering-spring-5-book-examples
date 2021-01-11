package io.mickeckemi21.masteringspring5bookexamples.springreactiveweb.repository

import io.mickeckemi21.masteringspring5bookexamples.springreactiveweb.model.Stock
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface StockReactiveCrudRepository : ReactiveCrudRepository<Stock, String> {
}
package io.mickeckemi21.masteringspring5bookexamples.springreactiveweb.controller

import io.mickeckemi21.masteringspring5bookexamples.springreactiveweb.model.Stock
import io.mickeckemi21.masteringspring5bookexamples.springreactiveweb.repository.StockReactiveCrudRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.*
import java.util.concurrent.ThreadLocalRandom

@RestController
class StockPriceEventController
constructor(private val stockRepository: StockReactiveCrudRepository) {

    @GetMapping("/stocks/price/{stockCode}")
    fun retrieveStockPriceHardcoded(
        @PathVariable("stockCode") stockCode: String
    ): Flux<String> = Flux.interval(Duration.ofSeconds(5))
        .map { "${getCurrentDate()} : ${getRandomNumber(100, 125)}" }
        .log()

    @GetMapping("/stocks")
    fun list(): Flux<Stock> =
        stockRepository.findAll().log()

    @GetMapping("/stocks/{code}")
    fun findById(@PathVariable("code") code: String): Mono<Stock> =
        stockRepository.findById(code).log()

    private fun getCurrentDate(): String =
        Date().toString()

    private fun getRandomNumber(min: Int, max: Int) =
        ThreadLocalRandom.current().nextInt(min, max + 1)

}
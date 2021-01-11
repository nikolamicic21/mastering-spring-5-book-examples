package io.mickeckemi21.masteringspring5bookexamples.springreactiveweb.bootstrap

import io.mickeckemi21.masteringspring5bookexamples.springreactiveweb.model.Stock
import io.mickeckemi21.masteringspring5bookexamples.springreactiveweb.repository.StockReactiveCrudRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DbInit {

    @Bean
    fun commandLineRunner(stockRepository: StockReactiveCrudRepository) =
        CommandLineRunner { args ->
            stockRepository.deleteAll().block()

            val stock1 = Stock()
            stock1.code = "IBM"
            stock1.name = "IBM Inc"
            stock1.description = "Desc"
            stockRepository.save(stock1).block()

            val stock2 = Stock()
            stock2.code = "GGL"
            stock2.name = "Google"
            stock2.description = "Desc"
            stockRepository.save(stock2).block()

            val stock3 = Stock()
            stock3.code = "MST"
            stock3.name = "Microsoft"
            stock3.description = "Desc"
            stockRepository.save(stock3).block()
        }

}
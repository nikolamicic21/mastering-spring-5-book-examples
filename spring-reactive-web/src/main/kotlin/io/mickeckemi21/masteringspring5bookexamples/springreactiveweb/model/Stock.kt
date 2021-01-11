package io.mickeckemi21.masteringspring5bookexamples.springreactiveweb.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Stock {

    @Id
    lateinit var code: String
    lateinit var name: String
    lateinit var description: String

}

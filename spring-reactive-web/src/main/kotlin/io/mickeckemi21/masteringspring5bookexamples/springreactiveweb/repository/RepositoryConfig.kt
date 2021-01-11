package io.mickeckemi21.masteringspring5bookexamples.springreactiveweb.repository

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableReactiveMongoRepositories(basePackages = ["io.mickeckemi21.masteringspring5bookexamples.springreactiveweb"])
class RepositoryConfig
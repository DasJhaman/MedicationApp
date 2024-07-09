package com.example.medicationapp.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module


fun initKoin(additionalModules: List<Module>): KoinApplication {
    return startKoin {
        modules(
            additionalModules +
                    coreModule +
                    viewModelModule +
                    useCaseModule +
                    apiModule +
                    repositoryModule
        )
    }
}

private val coreModule = module {
    single {
        HttpClient(engine = get()) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
            defaultRequest {
                // TODO: Add base url..
                url("")
            }

            install(Logging) {
                level = LogLevel.ALL
            }
        }
    }
}

private val viewModelModule = module {

}

private val useCaseModule = module {}

private val repositoryModule = module {}


private val apiModule = module {

}
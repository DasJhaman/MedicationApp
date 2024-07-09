package com.example.medicationapp

import android.app.Application
import android.content.Context
import com.example.medicationapp.di.initKoin
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(listOf(module {
            single<Context> { this@App }
        }))
    }
}
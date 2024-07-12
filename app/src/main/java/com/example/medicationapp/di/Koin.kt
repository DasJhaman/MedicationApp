package com.example.medicationapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.medicationapp.BuildConfig
import com.example.medicationapp.data.api.medication.MedicationApi
import com.example.medicationapp.data.db.MedicationDatabase
import com.example.medicationapp.data.db.dao.AssociatedDrugDao
import com.example.medicationapp.data.repo.MedicationRepository
import com.example.medicationapp.di.KoinQualifier.UNAUTHORIZED_ENGINE_QUALIFIER
import com.example.medicationapp.domain.AssociatedDrugUseCase
import com.example.medicationapp.ui.dashboard.DashboardScreenViewModel
import com.example.medicationapp.ui.drugdetails.DrugDetailsScreenViewModel
import com.example.medicationapp.ui.login.LoginViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module


fun initKoin(context: Context): KoinApplication {
    return startKoin {
        androidContext(context)
        modules(
            dataBaseModule +
                    apiModule +
                    coreModule +
                    viewModelModule +
                    useCaseModule +
                    repositoryModule
        )
    }
}

val coreModule = module {
    single {
        HttpClient(
            engine = get(named(UNAUTHORIZED_ENGINE_QUALIFIER)),
        ) {
            defaultRequest {
                url(BuildConfig.API_BASE_URL)
            }
            install(ContentNegotiation) {
                json(Json {
                    encodeDefaults = true
                    ignoreUnknownKeys = true
                }
                )
            }
            install(Logging) {
                level = LogLevel.ALL
            }
        }
    }
    single(named(UNAUTHORIZED_ENGINE_QUALIFIER)) {
        OkHttp.create {
        }
    }
}

fun provideDataBase(application: Application): MedicationDatabase =
    Room.databaseBuilder(
        application,
        MedicationDatabase::class.java,
        "medication_app"
    ).fallbackToDestructiveMigration().build()

fun provideDao(postDataBase: MedicationDatabase): AssociatedDrugDao =
    postDataBase.associatedDrugDao()


val dataBaseModule = module {
    single { provideDataBase(get()) }
    single { provideDao(get()) }
}

private val viewModelModule = module {
    viewModel { LoginViewModel() }
    viewModel { DashboardScreenViewModel(get(), get()) }
    viewModel { DrugDetailsScreenViewModel(get()) }
}

private val useCaseModule = module {
    singleOf(::AssociatedDrugUseCase)
}

private val repositoryModule = module {
    single { MedicationRepository(get(), get()) }
}


private val apiModule = module {
    singleOf(::MedicationApi)

}

object KoinQualifier {
    const val UNAUTHORIZED_ENGINE_QUALIFIER = "unauthorized_engine_qualifier"
}
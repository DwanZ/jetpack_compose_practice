package com.dwanz.jetpack_practice.data.di

import com.dwanz.jetpack_practice.data.PokemonRepository
import com.dwanz.jetpack_practice.data.source.remote.PokemonApi
import com.dwanz.jetpack_practice.data.source.remote.PokemonRemoteDataSource
import com.dwanz.jetpack_practice.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val DataModule = module {
    single {
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build()
            ).build()
            .create(PokemonApi::class.java)
    }

    factory  {
        PokemonRemoteDataSource(get())
    }

    factory  {
        PokemonRepository(get())
    }
}
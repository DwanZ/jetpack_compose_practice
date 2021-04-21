package com.dwanz.jetpack_practice.domain.di

import com.dwanz.jetpack_practice.domain.usecase.GetPokemonListUseCase
import com.dwanz.jetpack_practice.domain.usecase.GetPokemonseCase
import org.koin.dsl.module

val DomainModule = module {
    factory {
        GetPokemonseCase(get())
    }
    factory {
        GetPokemonListUseCase(get())
    }
}
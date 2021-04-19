package com.dwanz.jetpack_practice.data

import com.dwanz.jetpack_practice.data.entity.PokemonEntity
import com.dwanz.jetpack_practice.data.entity.PokemonListEntity
import retrofit2.Call

interface DataSource {
    suspend fun getPokemonByName(name: String): Call<PokemonEntity>

    suspend fun getPokemonsByPagination(offset: String): Call<PokemonListEntity>
}
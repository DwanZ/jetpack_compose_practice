package com.dwanz.jetpack_practice.data.source.remote

import com.dwanz.jetpack_practice.data.DataSource
import com.dwanz.jetpack_practice.data.entity.PokemonEntity
import com.dwanz.jetpack_practice.data.entity.PokemonListEntity
import retrofit2.Call


class PokemonRemoteDataSource(private val api: PokemonApi): DataSource {
    override suspend fun getPokemonByName(name: String): Call<PokemonEntity> {
        return api.getPokemonByName(name)
    }

    override suspend fun getPokemonsByPagination(offset: String): Call<PokemonListEntity> {
        return api.getPokemonsByPagination(offset)
    }

}
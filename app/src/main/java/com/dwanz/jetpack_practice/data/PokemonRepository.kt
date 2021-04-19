package com.dwanz.jetpack_practice.data

import com.dwanz.jetpack_practice.data.entity.PokemonEntity
import com.dwanz.jetpack_practice.data.entity.PokemonListEntity
import com.dwanz.jetpack_practice.data.source.remote.PokemonRemoteDataSource
import retrofit2.Call

class PokemonRepository(private val pokemonRemoteDataSource: PokemonRemoteDataSource): DataSource {
    override suspend fun getPokemonByName(name: String): Call<PokemonEntity> {
        return pokemonRemoteDataSource.getPokemonByName(name)
    }

    override suspend fun getPokemonsByPagination(offset: String): Call<PokemonListEntity> {
        return pokemonRemoteDataSource.getPokemonsByPagination(offset)
    }

}
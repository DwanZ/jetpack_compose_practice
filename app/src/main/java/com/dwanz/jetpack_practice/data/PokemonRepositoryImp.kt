package com.dwanz.jetpack_practice.data

import com.dwanz.jetpack_practice.data.entity.PokemonEntity
import com.dwanz.jetpack_practice.data.entity.PokemonListEntity
import com.dwanz.jetpack_practice.data.source.remote.PokemonRemoteDataSource
import com.dwanz.jetpack_practice.data.util.ApiResponse
import kotlinx.coroutines.flow.Flow

class PokemonRepositoryImp(private val pokemonRemoteDataSource: PokemonRemoteDataSource) :
    PokemonRepository {
    override fun getPokemonByName(name: String): Flow<ApiResponse<PokemonEntity>> {
        return pokemonRemoteDataSource.getPokemonByName(name)
    }

    override fun getPokemonsByPagination(offset: String): Flow<ApiResponse<PokemonListEntity>> {
        return pokemonRemoteDataSource.getPokemonsByPagination(offset)
    }
}
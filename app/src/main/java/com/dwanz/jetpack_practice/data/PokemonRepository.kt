package com.dwanz.jetpack_practice.data

import com.dwanz.jetpack_practice.data.entity.PokemonEntity
import com.dwanz.jetpack_practice.data.entity.PokemonListEntity
import com.dwanz.jetpack_practice.data.util.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Call

interface PokemonRepository {
    fun getPokemonByName(name: String): Flow<ApiResponse<PokemonEntity>>
    fun getPokemonsByPagination(offset: String): Flow<ApiResponse<PokemonListEntity>>
}
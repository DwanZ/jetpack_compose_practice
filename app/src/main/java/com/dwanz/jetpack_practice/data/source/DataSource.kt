package com.dwanz.jetpack_practice.data.source

import com.dwanz.jetpack_practice.data.entity.PokemonEntity
import com.dwanz.jetpack_practice.data.entity.PokemonListEntity
import com.dwanz.jetpack_practice.data.util.ApiResponse
import kotlinx.coroutines.flow.Flow

interface DataSource {
    fun getPokemonByName(name: String): Flow<ApiResponse<PokemonEntity>>

    fun getPokemonsByPagination(offset: String): Flow<ApiResponse<PokemonListEntity>>
}
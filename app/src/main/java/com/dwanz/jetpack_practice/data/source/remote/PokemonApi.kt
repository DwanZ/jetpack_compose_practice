package com.dwanz.jetpack_practice.data.source.remote

import com.dwanz.jetpack_practice.data.entity.PokemonEntity
import com.dwanz.jetpack_practice.data.entity.PokemonListEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon/{name}")
    fun getPokemonByName(@Path("name") name: String): Call<PokemonEntity>

    @GET("pokemon/?limit=30")
    fun getPokemonsByPagination(@Query("offset") offset: String): Call<PokemonListEntity>
}
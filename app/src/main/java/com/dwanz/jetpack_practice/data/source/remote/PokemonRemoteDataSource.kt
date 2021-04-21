package com.dwanz.jetpack_practice.data.source.remote

import com.dwanz.jetpack_practice.data.source.DataSource
import com.dwanz.jetpack_practice.data.entity.PokemonEntity
import com.dwanz.jetpack_practice.data.entity.PokemonListEntity
import com.dwanz.jetpack_practice.data.util.ApiResponse
import com.example.archmigrationexample.util.exceptions.ConectionException
import com.example.archmigrationexample.util.exceptions.EmptyResponseException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeoutException


class PokemonRemoteDataSource(private val api: PokemonApi) : DataSource {
    override fun getPokemonByName(name: String): Flow<ApiResponse<PokemonEntity>> {
        var result: ApiResponse<PokemonEntity> = ApiResponse.Error(TimeoutException())
        return flow {
            api.getPokemonByName(name).enqueue(object : Callback<PokemonEntity> {
                override fun onResponse(
                    call: Call<PokemonEntity>,
                    response: Response<PokemonEntity>
                ) {
                    if (response.isSuccessful) {
                        response.body().let {
                            it?.let {
                                result = ApiResponse.Success(it)
                            } ?: run {
                                result = ApiResponse.Error(EmptyResponseException())
                            }
                        }
                    } else {
                        result = ApiResponse.Error(ConectionException())
                    }
                }

                override fun onFailure(call: Call<PokemonEntity>, t: Throwable) {
                    result = ApiResponse.Error(t)
                }
            })
            emit(result)
        }
    }

    override fun getPokemonsByPagination(offset: String): Flow<ApiResponse<PokemonListEntity>> {
        var result: ApiResponse<PokemonListEntity> = ApiResponse.Error(TimeoutException())
        return flow {
            api.getPokemonsByPagination(offset).enqueue(object : Callback<PokemonListEntity> {
                override fun onResponse(
                    call: Call<PokemonListEntity>,
                    response: Response<PokemonListEntity>
                ) {
                    if (response.isSuccessful) {
                        response.body().let {
                            it?.let {
                                result = ApiResponse.Success<PokemonListEntity>(it)
                            } ?: run {
                                result = ApiResponse.Error(EmptyResponseException())
                            }
                        }
                    } else {
                        result = ApiResponse.Error(ConectionException())
                    }
                }
                override fun onFailure(call: Call<PokemonListEntity>, t: Throwable) {
                    result = ApiResponse.Error(t)
                }
            })
            emit(result)
        }
    }
}
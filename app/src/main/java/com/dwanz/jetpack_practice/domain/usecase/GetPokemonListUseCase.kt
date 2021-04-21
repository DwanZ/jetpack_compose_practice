package com.dwanz.jetpack_practice.domain.usecase

import com.dwanz.jetpack_practice.data.PokemonRepository

class GetPokemonListUseCase(val pokemonRepository: PokemonRepository) {
    fun getPokemonsByPagination(offset: String) = pokemonRepository.getPokemonsByPagination(offset)
}
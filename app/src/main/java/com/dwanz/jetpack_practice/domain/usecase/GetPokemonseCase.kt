package com.dwanz.jetpack_practice.domain.usecase

import com.dwanz.jetpack_practice.data.PokemonRepository

class GetPokemonseCase(val pokemonRepository: PokemonRepository) {
    fun getPokemonByName(name: String) = pokemonRepository.getPokemonByName(name)
}
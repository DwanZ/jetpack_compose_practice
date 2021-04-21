package com.dwanz.jetpack_practice.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dwanz.jetpack_practice.data.entity.PokemonListEntity
import com.dwanz.jetpack_practice.domain.usecase.GetPokemonListUseCase

class PokemonListViewModel(val getPokemonListUseCase: GetPokemonListUseCase) : ViewModel() {
    val pokeonList = MutableLiveData<PokemonListEntity>()
    var offset = 0

    init {
        getPokemonListUseCase.getPokemonsByPagination("$offset")
    }

    fun getPokemonList(increase: Int) {
        offset += increase
        getPokemonListUseCase.getPokemonsByPagination("$offset")
    }
}
package com.example.rickandmortyandroid.useCase

import com.example.rickandmortyandroid.repository.RickAndMortyRepository

class RickAandMortyUseCase(private val repository: RickAndMortyRepository) {

   suspend fun getCharacterAsync () = repository.listCharacterAsync()
}
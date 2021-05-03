package com.example.rickandmortyandroid.repository

import com.example.rickandmortyandroid.model.Info
import com.example.rickandmortyandroid.service.RickAndMortyService
import kotlinx.coroutines.*

class RickAndMortyRepository(private val service: RickAndMortyService) : RickAndMortyContract {
    override suspend fun listCharacterAsync() =
        withContext(Dispatchers.IO) {
            async {
                service.listCharactersAsync().await().results.map {
                    Info(it.name, it.image)
                }
            }
        }

    override suspend fun listChacarterPageAsync(page: Int): Deferred<List<Info>> {
        TODO("Not yet implemented")
    }

}
package com.example.rickandmortyandroid.repository

import com.example.rickandmortyandroid.model.Info
import kotlinx.coroutines.Deferred
import retrofit2.http.Query

interface RickAndMortyContract {

    suspend fun listCharacterAsync(): Deferred<List<Info>>

    suspend fun listChacarterPageAsync(@Query("page") page: Int): Deferred<List<Info>>
}
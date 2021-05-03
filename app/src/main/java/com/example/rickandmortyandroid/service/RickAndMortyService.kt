package com.example.rickandmortyandroid.service

import com.example.rickandmortyandroid.dto.RickAndMortyDTO
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyService {
    @GET("character")
    fun listCharactersAsync() : Deferred<RickAndMortyDTO>

    @GET("character")
    fun listChacarterPageAsync(@Query("page") page:Int) :Deferred<RickAndMortyDTO>
}
package com.example.rickandmortyandroid.di

import com.example.rickandmortyandroid.repository.RickAndMortyRepository
import com.example.rickandmortyandroid.retrofit.initRetrofit
import com.example.rickandmortyandroid.service.RickAndMortyService
import com.example.rickandmortyandroid.useCase.RickAandMortyUseCase
import com.example.rickandmortyandroid.viewModel.RickAndMortyViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val rickMortyModules = module {
    single { RickAndMortyRepository(get()) }
    single { RickAandMortyUseCase(get()) }
    single { initRetrofit() }
    single { get<Retrofit>().create(RickAndMortyService::class.java) }
    viewModel { RickAndMortyViewModel(get()) }
}
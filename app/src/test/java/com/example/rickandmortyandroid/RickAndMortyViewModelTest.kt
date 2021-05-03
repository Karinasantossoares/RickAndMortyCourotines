package com.example.rickandmortyandroid

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.rickandmortyandroid.model.Info
import com.example.rickandmortyandroid.useCase.RickAandMortyUseCase
import com.example.rickandmortyandroid.viewModel.RickAndMortyViewModel
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.verification.VerificationMode


@RunWith(MockitoJUnitRunner::class)
class RickAndMortyViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var useCase: RickAandMortyUseCase

    @Mock
    private lateinit var successListInfo: Observer<List<Info>>

    @Mock
    private lateinit var loadingLiveData: Observer<Boolean>

    @Mock
    private lateinit var errorLiveData: Observer<String>

    private lateinit var viewModel: RickAndMortyViewModel


    @Before
    fun setUp() {
        viewModel = RickAndMortyViewModel(useCase)
    }

    @Test
    fun `when the viewModel call getChacarter  with success then set suceesListInfo`() {
        runBlocking {
            val infoExpected: List<Info> = listOf(Info("teste","teste 2"))
            whenever(useCase.getCharacterAsync()).thenReturn(CompletableDeferred(infoExpected))
            viewModel.loadLiveData.observeForever(loadingLiveData)
            viewModel.successLiveData.observeForever(successListInfo)
            viewModel.errorLiveData.observeForever(errorLiveData)

            viewModel.getCharactereAssync()
            verify(loadingLiveData).onChanged(true)
            verify(successListInfo).onChanged(infoExpected)
            verify(loadingLiveData).onChanged(false)
            verify(errorLiveData, never()).onChanged(any())
        }
    }


}
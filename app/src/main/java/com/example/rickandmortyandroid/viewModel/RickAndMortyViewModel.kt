package com.example.rickandmortyandroid.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyandroid.model.Info
import com.example.rickandmortyandroid.useCase.RickAandMortyUseCase
import kotlinx.coroutines.launch

open class  RickAndMortyViewModel(private val useCase: RickAandMortyUseCase) : CoroutineViewModel() {

    var successLiveData = MutableLiveData<List<Info>>()
    var errorLiveData = MutableLiveData<String>()
    var loadLiveData = MutableLiveData<Boolean>()

    init {
        getCharactereAssync()
    }

    fun getCharactereAssync() = run {
        loadLiveData.value = true
        viewModelScope.launch {
            try {
                successLiveData.value = useCase.getCharacterAsync().await()
            } catch (ex: Exception) {
                errorLiveData.value = ex.localizedMessage
            } finally {
                loadLiveData.value = false
            }
        }
    }

}
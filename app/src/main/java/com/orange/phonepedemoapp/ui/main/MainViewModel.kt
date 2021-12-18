package com.orange.phonepedemoapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orange.phonepedemoapp.entity.Movies
import com.orange.phonepedemoapp.usecase.PopularMovieUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val useCase: PopularMovieUseCase) : ViewModel() {
    private var _data: MutableLiveData<Movies> = MutableLiveData<Movies>()
    var data: LiveData<Movies> = _data

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            _data.value = useCase.getPopularMovies()?.body()
        }
    }
}
package com.orange.phonepedemoapp.usecase

import com.orange.phonepedemoapp.entity.Movies
import com.orange.phonepedemoapp.service.IMDBMovieService
import retrofit2.Response
import javax.inject.Inject

interface PopularMovieUseCase {
    suspend fun getPopularMovies(): Response<Movies>?
}

class PopularUseCaseImpl @Inject constructor(private val service: IMDBMovieService) :
    PopularMovieUseCase {
    override suspend fun getPopularMovies(): Response<Movies>? {
        return service.getPopularMovies()
    }
}
package com.orange.phonepedemoapp.service

import com.orange.phonepedemoapp.entity.Movies
import retrofit2.Response
import retrofit2.http.GET

interface IMDBMovieService {
    @GET("search/repositories?q=retrofit")
    suspend fun getPopularMovies(): Response<Movies>?
}
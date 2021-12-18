package com.orange.phonepedemoapp.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.orange.phonepedemoapp.base.Constants
import com.orange.phonepedemoapp.service.IMDBMovieService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getRetrofit(gson: Gson, client: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build();

    }

    @Singleton
    @Provides
    fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun getGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Provides
    fun getIMDBApi(retrofit: Retrofit): IMDBMovieService {
        return retrofit.create(IMDBMovieService::class.java)
    }

}
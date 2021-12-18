package com.orange.phonepedemoapp.di.modules

import com.orange.phonepedemoapp.usecase.PopularMovieUseCase
import com.orange.phonepedemoapp.usecase.PopularUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class UserCaseModule {
    @Binds
    abstract fun bindMovieRepsoitory(useCase: PopularUseCaseImpl): PopularMovieUseCase
}
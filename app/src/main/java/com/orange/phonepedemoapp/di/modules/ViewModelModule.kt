package com.orange.phonepedemoapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.orange.demoapp.di.modules.ViewModelFactory
import com.orange.phonepedemoapp.ui.main.MainViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @MapKey
    annotation class ViewModelKey(val value: KClass<out ViewModel>)

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsMyViewModel(viewModel: MainViewModel): MainViewModel

}

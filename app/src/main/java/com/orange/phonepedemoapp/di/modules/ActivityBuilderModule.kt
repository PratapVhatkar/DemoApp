package com.orange.phonepedemoapp.di.modules

import com.orange.phonepedemoapp.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity
}

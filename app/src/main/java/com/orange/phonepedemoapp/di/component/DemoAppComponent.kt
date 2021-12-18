package com.orange.phonepedemoapp.di.component

import com.orange.phonepedemoapp.DemoApp
import com.orange.phonepedemoapp.di.modules.ActivityBuilderModule
import com.orange.phonepedemoapp.di.modules.NetworkModule
import com.orange.phonepedemoapp.di.modules.UserCaseModule
import com.orange.phonepedemoapp.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        UserCaseModule::class,
    ]
)
interface DemoAppComponent : AndroidInjector<DemoApp> {

    override fun inject(instance: DemoApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: DemoApp): Builder

        fun build(): DemoAppComponent
    }
}

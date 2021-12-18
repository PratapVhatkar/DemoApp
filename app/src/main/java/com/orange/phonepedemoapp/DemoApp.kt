package com.orange.phonepedemoapp

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class DemoApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerDemoAppComponent.builder().application(this).build()
    }
}

package com.prashant.end

import android.app.Application
import com.prashant.end.data.ApiServiceModule
import com.prashant.end.data.DaggerEndRepositoryComponent
import com.prashant.end.data.EndRepositoryComponent
import com.prashant.end.data.EndRepositoryModule
import timber.log.Timber

class EndApplication : Application() {

    lateinit var endRepositoryComponent: EndRepositoryComponent

    override fun onCreate() {
        super.onCreate()
        initializeDependencies()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    fun initializeDependencies() {
        endRepositoryComponent = DaggerEndRepositoryComponent.builder()
            .apiServiceModule(ApiServiceModule())
            .endRepositoryModule(EndRepositoryModule())
            .build()
    }
}
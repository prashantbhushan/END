package com.prashant.end

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val baseApp: EndApplication) {
    @Provides
    @Singleton
    fun provideApplication(): Application {
        return baseApp
    }
}
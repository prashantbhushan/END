package com.prashant.end.data

import com.prashant.end.AppModule
import com.prashant.end.data.repository.ProductListRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(EndRepositoryModule::class, AppModule::class, ApiServiceModule::class))
interface EndRepositoryComponent {
    fun provideProductListRepository(): ProductListRepository
}
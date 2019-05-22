package com.prashant.end.data

import com.prashant.end.data.repository.ProductListDataSource
import com.prashant.end.data.repository.remote.ProductListRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class EndRepositoryModule {

    @Provides
    @Remote
    @Singleton
    fun provideRemoteDataSource(remoteDataSource: ProductListRemoteDataSource): ProductListDataSource {
        return remoteDataSource
    }
}
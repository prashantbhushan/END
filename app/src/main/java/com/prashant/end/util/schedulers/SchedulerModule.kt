package com.prashant.end.util.schedulers

import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
class SchedulerModule {

    @Provides
    @RunOn(SchedulerType.IO)
    fun provideIO() = Schedulers.io()


    @Provides
    @RunOn(SchedulerType.UI)
    fun provideUI() = AndroidSchedulers.mainThread()

}
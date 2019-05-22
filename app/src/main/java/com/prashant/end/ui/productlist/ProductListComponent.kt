package com.prashant.end.ui.productlist

import com.prashant.end.data.EndRepositoryComponent
import com.prashant.end.ui.base.ActivityScope
import com.prashant.end.util.schedulers.SchedulerModule
import dagger.Component

@ActivityScope
@Component(
    modules = arrayOf(ProductListPresenterModule::class, SchedulerModule::class),
    dependencies = arrayOf(EndRepositoryComponent::class)
)
interface ProductListComponent {
    fun inject(activity: ProductListActivity)
}
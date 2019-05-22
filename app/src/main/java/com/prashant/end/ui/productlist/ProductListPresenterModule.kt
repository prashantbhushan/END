package com.prashant.end.ui.productlist

import dagger.Module
import dagger.Provides

@Module
class ProductListPresenterModule(val view: ProductListContract.View) {

    @Provides
    fun provideView(): ProductListContract.View = view

}
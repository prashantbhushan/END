package com.prashant.end.ui.productlist

import com.prashant.end.data.model.Product
import com.prashant.end.ui.base.BasePresenter

interface ProductListContract {
    interface View {
        fun showProductList(productList: List<Product>)

        fun setScreenTitle(title: String?)

        fun showErrorMessage(error: String)

        fun stopLoadingIndicator()

        fun showEmptyProductList(title: String?)
    }

    interface Presenter : BasePresenter<ProductListContract.View> {
        fun loadProductList()
    }
}
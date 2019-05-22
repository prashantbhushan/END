package com.prashant.end.data.repository

import com.prashant.end.data.api.ProductListResponse
import com.prashant.end.data.model.Product
import io.reactivex.Flowable

interface ProductListDataSource {
    fun loadProductList(): Flowable<ProductListResponse>
}
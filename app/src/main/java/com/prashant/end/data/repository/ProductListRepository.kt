package com.prashant.end.data.repository

import com.prashant.end.data.Remote
import com.prashant.end.data.api.ProductListResponse
import com.prashant.end.data.model.Product
import io.reactivex.Flowable
import javax.inject.Inject

class ProductListRepository @Inject constructor(@Remote private val remoteDataSource: ProductListDataSource) :
    ProductListDataSource {

    override fun loadProductList(): Flowable<ProductListResponse> {
        return remoteDataSource.loadProductList()
    }
}
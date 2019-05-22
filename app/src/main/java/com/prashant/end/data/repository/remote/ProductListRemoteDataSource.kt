package com.prashant.end.data.repository.remote

import com.prashant.end.data.api.EndApiService
import com.prashant.end.data.api.ProductListResponse
import com.prashant.end.data.repository.ProductListDataSource
import io.reactivex.Flowable
import javax.inject.Inject

class ProductListRemoteDataSource @Inject constructor(val endApiService: EndApiService) : ProductListDataSource {

    override fun loadProductList(): Flowable<ProductListResponse> = endApiService.getProducts()
}
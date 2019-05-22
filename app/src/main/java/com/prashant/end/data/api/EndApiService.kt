package com.prashant.end.data.api

import io.reactivex.Flowable
import retrofit2.http.GET

public interface EndApiService {
    @GET("media/catalog/example.json")
    fun getProducts(): Flowable<ProductListResponse>
}
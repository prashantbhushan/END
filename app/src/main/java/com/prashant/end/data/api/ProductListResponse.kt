package com.prashant.end.data.api

import com.google.gson.annotations.SerializedName
import com.prashant.end.data.model.Product

data class ProductListResponse(
    @SerializedName("title") val title: String?,
    @SerializedName("product_count") val productCount: Int?,
    @SerializedName("products") val products: List<Product>?
)
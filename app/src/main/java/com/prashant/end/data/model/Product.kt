package com.prashant.end.data.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("price") val price: String?,
    @SerializedName("image") val image: String
)
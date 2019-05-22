package com.prashant.end.ui.productlist

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.prashant.end.data.model.Product
import kotlinx.android.synthetic.main.product_list_item.view.*

class ProductListViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(product: Product) {
        Glide.with(view.ivProductImage).load(product.image).into(view.ivProductImage)
        view.tvProductName.text = product.name
        view.tvProductPrice.text = product.price
    }
}
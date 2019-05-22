package com.prashant.end.ui.productlist

import android.support.v7.widget.RecyclerView
import android.view.View
import com.prashant.end.R
import kotlinx.android.synthetic.main.product_list_item_count.view.*

class ProductListCountViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(count: Int) {
        view.tvProductsCount.setText(view.context.getString(R.string.items_count, count))
    }
}
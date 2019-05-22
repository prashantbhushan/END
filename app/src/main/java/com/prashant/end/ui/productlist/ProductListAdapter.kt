package com.prashant.end.ui.productlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.prashant.end.R
import com.prashant.end.data.model.Product

class ProductListAdapter(val productList: List<Product>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_COUNT = 0
    private val VIEW_TYPE_PRODUCT = 1

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            VIEW_TYPE_COUNT -> {
                val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.product_list_item_count, viewGroup, false)
                return ProductListCountViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.product_list_item, viewGroup, false)
                return ProductListViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        if (viewHolder is ProductListViewHolder) {
            viewHolder.bind(productList.get(position - 1))
        } else if (viewHolder is ProductListCountViewHolder) {
            viewHolder.bind(productList.size)
        }
    }

    override fun getItemViewType(position: Int): Int {
        when (position) {
            0 -> return VIEW_TYPE_COUNT
            else -> return VIEW_TYPE_PRODUCT
        }
    }
}
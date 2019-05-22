package com.prashant.end.ui.productlist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.prashant.end.EndApplication
import com.prashant.end.R
import com.prashant.end.data.model.Product
import kotlinx.android.synthetic.main.activity_product_list.*
import javax.inject.Inject


class ProductListActivity : AppCompatActivity(),
    ProductListContract.View {

    @Inject
    lateinit var presenter: ProductListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.prashant.end.R.layout.activity_product_list)
        initializePresenter()
        setTitle(getString(com.prashant.end.R.string.end))
    }

    private fun initializePresenter() {
        DaggerProductListComponent.builder()
            .productListPresenterModule(ProductListPresenterModule(this))
            .endRepositoryComponent((application as EndApplication).endRepositoryComponent)
            .build()
            .inject(this)
    }

    override fun showProductList(productList: List<Product>) {
        val layoutManager = GridLayoutManager(this, 2)

        // Create a custom SpanSizeLookup where the first item spans both columns
        layoutManager.setSpanSizeLookup(object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position == 0) 2 else 1
            }
        })

        rvProductList.layoutManager = layoutManager
        rvProductList.adapter = ProductListAdapter(productList)
        rvProductList.visibility = View.VISIBLE
    }

    override fun showErrorMessage(error: String) {

    }

    override fun stopLoadingIndicator() {
        pbProductList.visibility = View.GONE
    }

    override fun showEmptyProductList(title: String?) {
        tvProductListEmpty.text = getString(R.string.empty_product_list, title)
        tvProductListEmpty.visibility = View.VISIBLE
    }

    override fun setScreenTitle(title: String?) {
        title?.let { setTitle(title) }
    }
}
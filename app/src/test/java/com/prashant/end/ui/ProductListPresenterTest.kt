package com.prashant.end.ui

import com.prashant.end.data.api.ProductListResponse
import com.prashant.end.data.model.Product
import com.prashant.end.data.repository.ProductListRepository
import com.prashant.end.ui.productlist.ProductListContract
import com.prashant.end.ui.productlist.ProductListPresenter
import io.reactivex.Flowable
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ProductListPresenterTest {

    var productListResponse = ProductListResponse(
        "Test", 1,
        arrayListOf(Product("1", "Test", "Test", "Test"))
    )

    var emptyProductListResponse = ProductListResponse(
        "Test", 0,
        arrayListOf()
    )

    @Mock
    lateinit var repository: ProductListRepository

    @Mock
    lateinit var view: ProductListContract.View

    lateinit var presenter: ProductListPresenter

    lateinit var scheduler: TestScheduler

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        scheduler = TestScheduler()
        presenter = ProductListPresenter(repository, view, scheduler, scheduler)
    }

    @Test
    fun loadProductList_ShouldAlwaysStopLoadingIndicatorOnView_WhenComplete() {
        // given
        given(repository.loadProductList()).willReturn(Flowable.just(productListResponse))

        // when
        presenter.loadProductList()
        scheduler.triggerActions()

        // then
        then(view).should(Mockito.atLeastOnce()).stopLoadingIndicator()
    }

    @Test
    fun loadProductList_ShouldShowProductList_WithDataReturned() {
        // given
        given(repository.loadProductList()).willReturn(Flowable.just(productListResponse))

        // when
        presenter.loadProductList()
        scheduler.triggerActions()

        // then
        then(view).should(Mockito.atLeastOnce()).stopLoadingIndicator()
        then(view).should(Mockito.atLeastOnce()).showProductList(productListResponse.products!!)
    }

    @Test
    fun loadProductList_ShouldShowProductList_WithNoDataReturned() {
        // given
        given(repository.loadProductList()).willReturn(Flowable.just(emptyProductListResponse))

        // when
        presenter.loadProductList()
        scheduler.triggerActions()

        // then
        then(view).should(Mockito.atLeastOnce()).stopLoadingIndicator()
        then(view).should(Mockito.never()).showProductList(emptyProductListResponse.products!!)
        then(view).should(Mockito.atLeastOnce()).showEmptyProductList(ArgumentMatchers.any())
    }
}
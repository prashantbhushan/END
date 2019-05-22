package com.prashant.end.ui.productlist

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import com.prashant.end.data.api.ProductListResponse
import com.prashant.end.data.repository.ProductListRepository
import com.prashant.end.util.schedulers.RunOn
import com.prashant.end.util.schedulers.SchedulerType
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ProductListPresenter @Inject constructor(
    private val repository: ProductListRepository,
    private val view: ProductListContract.View,
    @RunOn(SchedulerType.IO) private val ioScheduler: Scheduler,
    @RunOn(SchedulerType.UI) private val uiScheduler: Scheduler
) : ProductListContract.Presenter, LifecycleObserver {

    var disposeBag: CompositeDisposable

    init {
        if (view is LifecycleOwner) {
            view.lifecycle.addObserver(this)
        }

        disposeBag = CompositeDisposable()
    }

    override @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onAttach() {
        loadProductList()
    }

    override @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onDetach() {
        disposeBag.clear()
    }

    override fun loadProductList() {
        val disposable = repository.loadProductList()
            .subscribeOn(ioScheduler)
            .observeOn(uiScheduler)
            .subscribe(this::handleData, this::handleError, { view.stopLoadingIndicator() })
        disposeBag.add(disposable)
    }

    fun handleData(productListResponse: ProductListResponse) {
        view.stopLoadingIndicator()
        view.setScreenTitle(productListResponse.title)
        if (productListResponse.products.isNullOrEmpty()) {
            view.showEmptyProductList(productListResponse.title)
        } else {
            view.showProductList(productListResponse.products)
        }
    }

    fun handleError(error: Throwable) {
        view.stopLoadingIndicator()
        view.showErrorMessage(error.localizedMessage)
    }
}
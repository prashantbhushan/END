package com.prashant.end.ui.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleRegistry
import android.support.v7.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    val lifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}
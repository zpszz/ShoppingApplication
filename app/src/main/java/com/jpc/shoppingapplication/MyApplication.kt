package com.jpc.shoppingapplication

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import java.lang.IllegalStateException
import java.lang.ref.WeakReference

class MyApplication: Application(){
    companion object{
        // 创建一个弱引用对象，用于保存上下文对象
        // 这样可以避免内存泄漏
        private var weakContext: WeakReference<Context>? = null
        val context: Context
            get() = weakContext?.get() ?: throw IllegalStateException("context is null")
    }

    override fun onCreate() {
        super.onCreate()
        weakContext = WeakReference(applicationContext)
    }
}
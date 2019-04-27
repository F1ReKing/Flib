package com.f1reking.flib.base

import android.app.Application
import com.squareup.leakcanary.LeakCanary

/**
 * @author: F1ReKing
 * @date: 2019/3/28 23:11
 * @desc:
 */
open class BaseLibApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }
}
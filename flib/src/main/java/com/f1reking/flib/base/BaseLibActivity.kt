package com.f1reking.flib.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author: F1ReKing
 * @date: 2019/3/28 22:31
 * @desc:
 */
abstract class BaseLibActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onPreView()
        setContentView(getLayoutId())
        initView()
    }

    abstract fun onPreView()

    abstract fun getLayoutId(): Int

    abstract fun initView()


}
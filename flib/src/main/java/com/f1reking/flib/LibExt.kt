package com.f1reking.flib

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

/**
 * @author: F1ReKing
 * @date: 2019/3/31 16:02
 * @desc:
 */
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT)
        .show()
}

fun Context.toast(@StringRes id: Int) {
    toast(getString(id))
}

fun Context.inflater(@LayoutRes res: Int): View = LayoutInflater.from(this).inflate(res, null)

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context)
        .inflate(layoutRes, this, attachToRoot)
}

inline fun OOIS(f: () -> Unit): Boolean {
    f()
    return true
}

fun String.toDate(pattern: String): Date? {
    try {
        val sdf = SimpleDateFormat(pattern, Locale.CHINA)
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        return sdf.parse(this)
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
    return null
}
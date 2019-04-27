package com.f1reking.flib.api

import android.util.Log
import com.f1reking.flib.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author: F1ReKing
 * @date: 2019/3/31 22:50
 * @desc:
 */
class ApiClient {

  private object Holder {
    val INSTANCE = ApiClient()
  }

  companion object {
    val instance by lazy { Holder.INSTANCE }
  }

  fun <T> getService(baseUrl: String,
                     service: Class<T>): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(getOkHttpClient())
        .build()
    return retrofit.create(service)
  }

  private fun getOkHttpClient(): OkHttpClient {
    val httpClientBuilder = OkHttpClient.Builder() //设置日志
    if (BuildConfig.DEBUG) {
      val logging = HttpLoggingInterceptor {
        Log.d("api", it)
      }
      logging.level = HttpLoggingInterceptor.Level.BODY
      httpClientBuilder.addInterceptor(logging)
    }
//        httpClientBuilder.sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
//        httpClientBuilder.hostnameVerifier(SSLSocketClient.getHostnameVerifier())
    return httpClientBuilder.build()
  }
}
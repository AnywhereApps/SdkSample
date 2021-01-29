package com.anywhereapps.sdk.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


internal object RetrofitBuilder {

    private const val BASE_URL1 = "https://api.yelp.com/"

    private fun getRetrofit(logging : Boolean): Retrofit {
        val client = if (logging) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder().addInterceptor(interceptor).build()
        } else {
            OkHttpClient.Builder().build()
        }

        return Retrofit.Builder()
            .baseUrl(BASE_URL1)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    fun getService(boolean: Boolean) : ApiService = getRetrofit(boolean).create(ApiService::class.java)

}


package com.example.kotlindemo.helpers

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder{

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    // Create OkHttp Client
    private val okHttp = OkHttpClient.Builder()

    // Create Retrofit Builder
    private val builder = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    // Create Retrofit Instance
    private val retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}
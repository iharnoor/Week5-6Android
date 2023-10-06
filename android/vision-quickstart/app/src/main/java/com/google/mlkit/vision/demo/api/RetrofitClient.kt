package com.google.mlkit.vision.demo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

//    val BASE_URL = "http://10.0.2.2:5000"
    val BASE_URL = "http://chatgptvm.eastus.cloudapp.azure.com"
    fun getInstance(): Retrofit {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit
    }
}

package com.example.ahmed.ismailiacityguidekotlinapp

import android.app.Application
import com.example.ahmed.ismailiacityguidekotlinapp.api.ApiResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {
    companion object {
        lateinit var api: ApiResponse
    }

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(ApiResponse::class.java)

    }
}
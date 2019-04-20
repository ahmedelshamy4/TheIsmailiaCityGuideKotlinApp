package com.example.ahmed.ismailiacityguidekotlinapp.api

import com.example.ahmed.ismailiacityguidekotlinapp.model.Coffees
import com.example.ahmed.ismailiacityguidekotlinapp.model.Hospital
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface ApiResponse {
    @GET("json?query=ismalia+coffe&key=AIzaSyDgChPwVs86RFhov7SZwCKNDU27XlBxCRM")
    fun getCoffes(): Call<Coffees>

    @GET("json?query=ismalia+hospital&key=AIzaSyDgChPwVs86RFhov7SZwCKNDU27XlBxCRM")
    fun getHospital(): Call<Hospital>
}


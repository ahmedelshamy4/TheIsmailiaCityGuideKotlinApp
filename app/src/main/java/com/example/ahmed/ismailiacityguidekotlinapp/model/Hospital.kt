package com.example.ahmed.ismailiacityguidekotlinapp.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class Hospital(
    @field:SerializedName("results")
    val results: ArrayList<Hospital>? = null,
    @field:SerializedName("id")
    val id: String? = null,
    @field:SerializedName("rating")
    var Rating: Float = 0.toFloat(),
    @field:SerializedName("name")
    var name: String? = null,
    @field:SerializedName("icon")
    var icon: String? = null
)

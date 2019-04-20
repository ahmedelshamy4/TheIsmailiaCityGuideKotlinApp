package com.example.ahmed.ismailiacityguidekotlinapp.ui.coffee

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.ahmed.ismailiacityguidekotlinapp.Constant
import com.example.ahmed.ismailiacityguidekotlinapp.MyApplication
import com.example.ahmed.ismailiacityguidekotlinapp.R
import com.example.ahmed.ismailiacityguidekotlinapp.adapter.CoffeeAdapter
import com.example.ahmed.ismailiacityguidekotlinapp.model.Coffees
import com.example.ahmed.ismailiacityguidekotlinapp.ui.detailCoffe.DetailCoffeeActivity
import kotlinx.android.synthetic.main.activity_coffes.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class CoffesActivity : AppCompatActivity() {

    private lateinit var adapterCoffee: CoffeeAdapter
    private val coffeList = mutableListOf<Coffees>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffes)
        title = "Coffees List"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(supportActionBar)?.setDisplayHomeAsUpEnabled(true)
        }
        setUpIntentViews()
        loadData()

    }

    private fun setUpIntentViews() {

        adapterCoffee = CoffeeAdapter(coffeList)
        recyclerViewCoffe.layoutManager = LinearLayoutManager(this)
        recyclerViewCoffe.adapter = adapterCoffee
        progressBar.visibility = View.VISIBLE

    }


    private fun loadData() {

        MyApplication.api.getCoffes().enqueue(object : Callback<Coffees> {
            override fun onFailure(call: Call<Coffees>, t: Throwable) {
                Log.e("Error", t?.message)
                progressBar.visibility = View.GONE
            }

            override fun onResponse(call: Call<Coffees>, response: Response<Coffees>) {
                progressBar.visibility = View.GONE
                if (response != null) {
                    coffeList.clear()
                    response.body()!!.results.let {
                        if (it != null) {
                            coffeList.addAll(it)
                        }
                        adapterCoffee.notifyDataSetChanged()

                    }
                }
            }

        })

    }


}


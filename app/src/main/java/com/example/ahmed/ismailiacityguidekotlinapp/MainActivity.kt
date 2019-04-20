package com.example.ahmed.ismailiacityguidekotlinapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.ahmed.ismailiacityguidekotlinapp.model.Coffees
import com.example.ahmed.ismailiacityguidekotlinapp.ui.coffee.CoffesActivity

class MainActivity : AppCompatActivity() {
    private lateinit var coffeIv: ImageView
    private lateinit var hospitalIv: ImageView
    private lateinit var resturantIv: ImageView
    private lateinit var schoolIv: ImageView
    private lateinit var cinemaIv: ImageView
    private lateinit var hotelIv: ImageView

    private lateinit var coffeCv: CardView
    private lateinit var hospitalCv: CardView
    private lateinit var resturantCv: CardView
    private lateinit var schoolCv: CardView
    private lateinit var cinemaCv: CardView
    private lateinit var hotelCv: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        onClicks()
    }


    private fun initView() {
        coffeIv = findViewById(R.id.coffeIV)
        hospitalIv = findViewById(R.id.hospitalIV)
        resturantIv = findViewById(R.id.returantIV)
        schoolIv = findViewById(R.id.schoolIV)
        cinemaIv = findViewById(R.id.cinemaIV)
        hotelIv = findViewById(R.id.hotelIV)

        coffeCv = findViewById(R.id.coffesCV)
        hospitalCv = findViewById(R.id.hospitalCV)
        resturantCv = findViewById(R.id.resturantCV)
        schoolCv = findViewById(R.id.schoolCV)
        cinemaCv = findViewById(R.id.cinemaCV)
        hotelCv = findViewById(R.id.hotelCV)

        loadImage(coffeIv, R.drawable.coffee)
        loadImage(hospitalIv, R.drawable.hospital)
        loadImage(resturantIv, R.drawable.resturant)
        loadImage(schoolIv, R.drawable.school)
        loadImage(cinemaIv, R.drawable.cinema)
        loadImage(hotelIv, R.drawable.hotel)

    }

    private fun onClicks() {
        coffeCv.setOnClickListener {
            val intent = Intent(this, CoffesActivity::class.java)
            startActivity(intent)
        }
    }

    internal fun loadImage(imageView: ImageView, drawable: Int?) {
        Glide.with(this).load(drawable).into(imageView)
    }
}

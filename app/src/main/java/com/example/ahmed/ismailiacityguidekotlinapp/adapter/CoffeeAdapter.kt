package com.example.ahmed.ismailiacityguidekotlinapp.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.ahmed.ismailiacityguidekotlinapp.Constant
import com.example.ahmed.ismailiacityguidekotlinapp.R
import com.example.ahmed.ismailiacityguidekotlinapp.model.Coffees
import com.example.ahmed.ismailiacityguidekotlinapp.ui.detailCoffe.DetailCoffeeActivity
import kotlinx.android.synthetic.main.layout_list_coffes.view.*

class CoffeeAdapter(private val coffeeList: List<Coffees>) : RecyclerView.Adapter<CoffeeAdapter.coffeeViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CoffeeAdapter.coffeeViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.layout_list_coffes, p0, false)
        return coffeeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return coffeeList.size
    }

    override fun onBindViewHolder(holder: CoffeeAdapter.coffeeViewHolder, position: Int) {
        holder.bind(position)

    }

    inner class coffeeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(position: Int) {
            val context = itemView.context
            val coffeResult: Coffees = coffeeList[position]
            itemView.tv_coffes.text = coffeeList.get(position).name
            Glide.with(context)
                .load(coffeResult.icon)
                .into(itemView.iv_thumb)
            itemView.card_view_coffee.setOnClickListener {
                val intent = Intent(context, DetailCoffeeActivity::class.java)
                intent.putExtra(Constant.DATA_ID, coffeResult.id)
                intent.putExtra(Constant.DATA_ICON, coffeResult.icon)
                intent.putExtra(Constant.DATA_TITLE, coffeResult.name)
                intent.putExtra(Constant.DATA_RATING, coffeResult.Rating)
                context.startActivity(intent)
            }

        }

    }
}
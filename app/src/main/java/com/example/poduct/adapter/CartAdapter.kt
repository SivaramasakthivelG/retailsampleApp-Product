package com.example.poduct.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.poduct.R
import com.example.poduct.data.ProductResponseItem
import com.example.poduct.databinding.CartListBinding

class CartAdapter(val responseItem: ProductResponseItem?,val  countItem: Int?) : RecyclerView.Adapter<CartAdapter.MyViewHolder>() {


    private val list = ArrayList<ProductResponseItem>()
    private val TAG = "check"


    inner class MyViewHolder(var binding: CartListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.MyViewHolder {
        val binding = CartListBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        list.add(responseItem!!)

        Log.d(TAG, "onCreateViewHolder: $countItem")
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(holder.binding.root).load(list.get(position).image)
            .placeholder(R.drawable.loading)
            .into(holder.binding.imageView3)

        holder.binding.priceTv.text = list.get(position).price.toString()
        holder.binding.countTv.text = countItem.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }


}
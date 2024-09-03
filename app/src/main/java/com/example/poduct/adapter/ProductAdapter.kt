package com.example.poduct.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.poduct.Interfaces.AdapterClickListeners
import com.example.poduct.R
import com.example.poduct.data.ProductResponse
import com.example.poduct.databinding.IemListBinding

class ProductAdapter(val data: ProductResponse?,val listeners: AdapterClickListeners) : RecyclerView.Adapter<ProductAdapter.MyViewHolder>(){

     inner class MyViewHolder (var binding: IemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.MyViewHolder {
        var binding = IemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductAdapter.MyViewHolder, position: Int) {

       holder.binding.textvir.text = data!!.get(position).price.toString()

       Glide.with(holder.itemView.context).load(data.get(position).image)
           .placeholder(R.drawable.loading)
           .into(holder.binding.imageView)

       holder.binding.imageView.setOnClickListener{
            listeners.clickListener(data.get(position))
       }
    }


    override fun getItemCount(): Int {
       return data!!.size
    }

}

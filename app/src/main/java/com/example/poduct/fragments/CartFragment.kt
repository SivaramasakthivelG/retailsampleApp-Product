package com.example.poduct.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.poduct.R
import com.example.poduct.adapter.CartAdapter
import com.example.poduct.data.ProductResponseItem
import com.example.poduct.databinding.CartFragmentBinding
import com.example.poduct.viewmodel.CartViewModel

class CartFragment : Fragment(){

    var responseItem: ProductResponseItem?= null
    private val viewModel by viewModels<CartViewModel>()
    var countItem: Int?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = CartFragmentBinding.inflate(inflater,container,false)
        responseItem = requireArguments().getParcelable<ProductResponseItem>("productResponse",)
        countItem = requireArguments().getInt("count")

        Glide.with(binding.root).load(responseItem!!.image).placeholder(R.drawable.loading)
            .into(binding.imageView2)
        binding.textView.text = countItem.toString()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var cartAdapter = CartAdapter(responseItem,countItem)
    }
}
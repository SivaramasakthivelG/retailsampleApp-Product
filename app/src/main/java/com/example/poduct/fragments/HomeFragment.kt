package com.example.poduct.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.poduct.Interfaces.AdapterClickListeners
import com.example.poduct.adapter.ProductAdapter
import com.example.poduct.data.ProductResponseItem
import com.example.poduct.databinding.FragmentHomeBinding
import com.example.poduct.viewmodel.ProductViewModel


class HomeFragment : Fragment(),AdapterClickListeners {

    private val viewmodel by viewModels<ProductViewModel>()

    lateinit var binding  : FragmentHomeBinding

    val TAG: String = "eeeeeee"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView: ")
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.liveData.observe(viewLifecycleOwner, Observer {

            var data = it.body()
            var adapter = ProductAdapter(data,this)
            binding.recyclerView.adapter = adapter

        })
    }

    override fun clickListener(productResponse: ProductResponseItem) {
        findNavController().navigate(com.example.poduct.R.id.productDescriptionFragment,
            bundleOf("productResponse" to productResponse))
    }

}
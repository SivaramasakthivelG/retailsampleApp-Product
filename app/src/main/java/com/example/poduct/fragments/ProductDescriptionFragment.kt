package com.example.poduct.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.*
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.poduct.Interfaces.CartDetailsListeners
import com.example.poduct.MainActivity
import com.example.poduct.R
import com.example.poduct.data.ProductResponseItem
import com.example.poduct.databinding.FragmentProductDescriptionBinding
import kotlinx.parcelize.Parcelize

class ProductDescriptionFragment : Fragment(){

    lateinit var listeners: CartDetailsListeners

    private var countValue: Int?= 1

    val TAG = "Value"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProductDescriptionBinding.inflate(inflater,container,false)

        val data = requireArguments().getParcelable<ProductResponseItem>("productResponse")


        binding.descriptionTv.text = data!!.description
        Glide.with(binding.root).load(data.image).placeholder(R.drawable.loading)
            .into(binding.descriptionImage)

        val countRange = (1..50).toList()
        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,countRange)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.apply {
            countSpinner.adapter = adapter

            countSpinner.onItemSelectedListener = object: OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    countValue = position + 1
                    Toast.makeText(binding.root.context, "Button clicked", Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }




            cartButton.setOnClickListener{
                findNavController().navigate(

                    R.id.cartFragment,
                    bundleOf("productResponse" to data,"count" to countValue))

            }
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }



}
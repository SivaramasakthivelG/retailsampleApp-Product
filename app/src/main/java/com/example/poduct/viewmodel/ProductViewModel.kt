package com.example.poduct.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.poduct.Constant
import com.example.poduct.data.ProductResponse
import com.example.poduct.Interfaces.Retrofit
import retrofit2.Response

class ProductViewModel() : ViewModel() {

    var retrofits = Constant.getretrofit()
    var retrofitservice = retrofits.create(Retrofit::class.java)


    val liveData: LiveData<Response<ProductResponse>> =
        liveData {
            val response = retrofitservice.getAllItems()
            emit(response)
        }



}
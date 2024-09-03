package com.example.poduct

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constant {

    val BASE_URL = "https://fakestoreapi.com/"


    fun getretrofit() : Retrofit{

        return retrofit2.Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    }

}
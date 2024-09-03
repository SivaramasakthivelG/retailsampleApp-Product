package com.example.poduct.Interfaces

import com.example.poduct.data.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Retrofit {

    @GET("/products")
    suspend fun getAllItems(
    ): Response<ProductResponse>
}
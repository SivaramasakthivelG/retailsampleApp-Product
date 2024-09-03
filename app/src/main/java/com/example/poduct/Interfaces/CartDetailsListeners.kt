package com.example.poduct.Interfaces

import com.example.poduct.data.ProductResponseItem

interface CartDetailsListeners {

    fun cartDetails(productResponse: ProductResponseItem?, count: Int)

}
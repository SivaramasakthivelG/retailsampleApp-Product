package com.example.poduct.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.poduct.data.ProductResponseItem

class CartViewModel : ViewModel() {
    private val _cartItems = MutableLiveData<List<ProductResponseItem>>()
    val cartItems: LiveData<List<ProductResponseItem>> get() = _cartItems

    init {
        _cartItems.value = ArrayList()
    }

    fun addCartItem(item: ProductResponseItem) {
        val currentList = _cartItems.value as ArrayList
        currentList.add(item)
        _cartItems.value = currentList
    }

    fun updateCartItems(items: List<ProductResponseItem>) {
        _cartItems.value = items
    }
}

package com.example.poduct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar.OnNavigationListener
import androidx.lifecycle.Observer
import com.example.poduct.Interfaces.CartDetailsListeners
import com.example.poduct.adapter.ProductAdapter
import com.example.poduct.databinding.ActivityMainBinding
import com.example.poduct.fragments.HomeFragment
import com.example.poduct.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity(){

    lateinit var cartListener: CartDetailsListeners

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}
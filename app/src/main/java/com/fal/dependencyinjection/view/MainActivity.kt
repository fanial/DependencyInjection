package com.fal.dependencyinjection.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fal.dependencyinjection.R
import com.fal.dependencyinjection.databinding.ActivityMainBinding
import com.fal.dependencyinjection.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
    }

    private fun getData() {
        val model = ViewModelProvider(this).get(ProductViewModel::class.java)
        model.callApiProduct()
        model.getliveData().observe(this, Observer{
            adapter = ProductAdapter(it)
            if (it != null){
                binding.rvList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvList.adapter = ProductAdapter(it)
            }
        })
    }
}
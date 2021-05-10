package com.example.doordashlite.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doordashlite.R
import com.example.doordashlite.databinding.ActivityMainBinding
import com.example.doordashlite.utils.Status
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: StoreAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)

        setContentView(R.layout.activity_main)

        setView()
        setObserver()

    }

    private fun setView(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        adapter = StoreAdapter()
        binding.storesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.storesRecyclerView.adapter = adapter
    }

    private fun setObserver(){
        mainViewModel.res.observe(this, Observer {
            when(it.status) {
                Status.SUCCESS -> {
                    binding.progress.visibility = View.GONE
                    binding.storesRecyclerView.visibility = View.VISIBLE
                    it.data.let {
                        res -> res?.stores.let { it1 -> adapter.submitList(it1) }
                    }

                }
                Status.ERROR -> {
                    binding.progress.visibility = View.GONE
                    binding.storesRecyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    binding.progress.visibility = View.VISIBLE
                    binding.storesRecyclerView.visibility = View.GONE
                }
            }
        })
    }
}
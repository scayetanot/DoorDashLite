package com.example.doordashlite.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.doordashlite.R
import com.example.doordashlite.data.RestaurantResponse
import com.example.doordashlite.databinding.ActivityDetailsBinding
import com.example.doordashlite.ui.MainActivity.Companion.BUSINESSID
import com.example.doordashlite.utils.Status
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private val detailsViewModel: DetailsViewModel by viewModels()
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val businessId = intent.getIntExtra(BUSINESSID, 0)
        setView(businessId)
        setObserver()

    }

    private fun setView(businessId: Int){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        detailsViewModel.getRestaurantDetails(businessId)
    }

    private fun setObserver(){
        detailsViewModel.res.observe( this, Observer {
            when(it.status) {
                Status.SUCCESS -> {
                    binding.progress.visibility = View.GONE
                    binding.restaurantLayout.visibility = View.VISIBLE
                    updateView(it.data)

                }
                Status.ERROR -> {
                    binding.progress.visibility = View.GONE
                    binding.restaurantLayout.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    binding.progress.visibility = View.VISIBLE
                    binding.restaurantLayout.visibility = View.GONE
                }
            }
        })
    }

    private fun updateView(resp: RestaurantResponse?){
        binding.ivCover.setImageURI(resp?.cover_img_url)
        binding.tvName.text = resp?.name.toString()
        binding.tvDescription.text = resp?.description.toString()
      //  binding.setVariable(BR.viewModel, resp)
      //  binding.executePendingBindings()
    }


}

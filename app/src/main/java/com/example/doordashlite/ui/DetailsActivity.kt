package com.example.doordashlite.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
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
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions


@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private val detailsViewModel: DetailsViewModel by viewModels()
    private lateinit var binding: ActivityDetailsBinding

    private lateinit var mapFragment: SupportMapFragment
    private lateinit var mapGoogle: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val businessId = intent.getIntExtra(BUSINESSID, 0)
        setView(businessId)
        setMap()
        setObserver()

    }

    private fun setView(businessId: Int){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        detailsViewModel.getRestaurantDetails(businessId)
    }

    private fun setMap(){
        mapFragment = getSupportFragmentManager().findFragmentById(R.id.map_fragment) as SupportMapFragment
        if (mapFragment != null) {
            try{
                mapFragment.getMapAsync(OnMapReadyCallback {
                    mapGoogle = it
                })
            } catch (e: Exception) {
                binding.map.visibility = View.GONE
                Toast.makeText(this, "Error - Impossible to load Map", Toast.LENGTH_SHORT).show()
            }
        } else {
            binding.map.visibility = View.GONE
            Toast.makeText(this, "Error - Impossible to load Map", Toast.LENGTH_SHORT).show()
        }
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
        binding.tvPriceRange.text = setNumberOfDollar(resp?.price_range)
        binding.tvDescription.text = resp?.description.toString()

        resp?.address.let {
            locationLocationOnMap(it!!.lat, it.lng)
            binding.address.text = it.printable_address
        }
      //  binding.setVariable(BR.viewModel, resp)
      //  binding.executePendingBindings()
    }

    private fun setNumberOfDollar(nb: Int?): String {
        var tmp: String = ""
        for (i in 0..nb!!) {
            tmp += getString(R.string.currency)
        }
        return tmp
    }

    private fun locationLocationOnMap(lat: Double, lon: Double) {

        val place = LatLng(lat, lon)
        val cameraLocation: CameraPosition = CameraPosition.Builder().
        target(place)
                .zoom(16.0f)
                .bearing(0f)
                .build()

        mapGoogle.addMarker(MarkerOptions().position(place))
        mapGoogle.moveCamera(CameraUpdateFactory.newCameraPosition(cameraLocation))
    }

}

package com.example.doordashlite.repository

import com.example.doordashlite.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper
){
    suspend fun getListOfStores(lat: Double, lon: Double) = apiHelper.getListOfStores(lat, lon)
    suspend fun getRestaurantDetails(businessId: Int) = apiHelper.getRestaurantDetails(businessId)
}
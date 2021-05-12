package com.example.doordashlite.api

import com.example.doordashlite.data.RestaurantResponse
import com.example.doordashlite.data.StoreFeedResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
):ApiHelper {
    override suspend fun getListOfStores(lat: Double, lon: Double): Response<StoreFeedResponse> =
        apiService.getListOfStores(lat, lon)

    override suspend fun getRestaurantDetails(id: Int): Response<RestaurantResponse>  =
        apiService.getRestaurantDetails(id)

}
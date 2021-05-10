package com.example.doordashlite.api

import com.example.doordashlite.data.StoreFeedResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getListOfStores(lat: Double, lon: Double): Response<StoreFeedResponse>
}
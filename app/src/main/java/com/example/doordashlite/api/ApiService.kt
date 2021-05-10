package com.example.doordashlite.api

import com.example.doordashlite.data.StoreFeedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v1/store_feed/?&offset=0&limit=50")
    suspend fun getListOfStores(
        @Query("lat") lat: Double,
        @Query("long") lon: Double
    ): Response<StoreFeedResponse>
}
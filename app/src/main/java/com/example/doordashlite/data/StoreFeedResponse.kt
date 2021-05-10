package com.example.doordashlite.data

import com.squareup.moshi.Json

data class StoreFeedResponse(
        var numResults: Int? = 0,
        @Json(name = "is_first_time_user") var isFirstTimeUser: Boolean?,
        @Json(name = "sort_order") var sortOrder: String? = "",
        @Json(name = "next_offset") var nextOffset: Int? = 0,
        @Json(name = "show_list_as_pickup") var showListAsPickup: Boolean?,
        var stores: List<Store>
)
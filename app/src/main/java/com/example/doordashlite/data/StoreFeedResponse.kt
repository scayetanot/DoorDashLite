package com.example.doordashlite.data

import com.google.gson.annotations.SerializedName

data class StoreFeedResponse(
        var numResults: Int? = 0,
        @SerializedName("is_first_time_user") var isFirstTimeUser: Boolean?,
        @SerializedName("sort_order") var sortOrder: String? = "",
        @SerializedName("next_offset") var nextOffset: Int? = 0,
        @SerializedName("show_list_as_pickup") var showListAsPickup: Boolean?,
        var stores: List<Store>
)
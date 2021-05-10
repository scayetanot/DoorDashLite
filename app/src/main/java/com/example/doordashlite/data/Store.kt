package com.example.doordashlite.data

import com.squareup.moshi.Json


data class Store(
        var id: Int? = 0,
        var name: String?,
        var description: String?,
        @Json(name = "cover_image_url") var coverImageUrl: String?,
        @Json(name = "next_close_time") var nextCloseTime: String?,
) {
    fun getCloseTime(): String? {
        return ""
    }
}
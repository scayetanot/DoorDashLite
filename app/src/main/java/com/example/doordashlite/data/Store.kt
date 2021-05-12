package com.example.doordashlite.data

import android.content.Context
import android.service.autofill.Validators.not
import com.example.doordashlite.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*


data class Store(
        var id: Int? = 0,
        var name: String?,
        var description: String?,
        var cover_img_url: String?,
        var next_close_time: String?,
        var business_id: Int?
) {
    fun getCloseTime(): String? {
        return "Maybe"
        val timeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH)
        val diff: Duration = Duration.between(
                LocalTime.parse(LocalTime.now(ZoneOffset.UTC).toString(), timeFormatter),
                LocalTime.parse(next_close_time, timeFormatter))
        return when {
            (diff.toDays().toInt() > 0 ) -> "Open"
            !diff.isNegative -> diff.toMinutes().toString()
            else -> "Closed"
        }
    }

    private fun getISO8601StringForDate(): String? {
        val now = Date()
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"))
        return dateFormat.format(now)
    }
}
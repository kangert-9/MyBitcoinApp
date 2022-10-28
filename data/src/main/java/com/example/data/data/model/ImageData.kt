package com.example.data.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageData(
    @SerializedName("large")
    val large: String?,
) : Parcelable
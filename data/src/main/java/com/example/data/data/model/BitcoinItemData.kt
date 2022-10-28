package com.example.data.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BitcoinItemData(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("image")
    val image: ImageData?,
    @SerializedName("description")
    val description: DescriptionData?,
    @SerializedName("categories")
    val categories: List<String?>?) : Parcelable
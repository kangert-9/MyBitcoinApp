package com.example.data.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BitcoinData(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("current_price")
    val current_price: String?,
    @SerializedName("ath_change_percentage")
    val ath_change_percentage: String?) : Parcelable
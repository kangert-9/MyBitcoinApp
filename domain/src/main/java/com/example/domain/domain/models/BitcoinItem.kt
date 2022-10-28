package com.example.domain.domain.models


data class BitcoinItem(
    val id: String?,
    val name: String?,
    val image: Image?,
    val description: Description?,
    val categories: List<String?>?)


data class Image(
    val large: String?,
)


data class Description(
    val en: String?,
)
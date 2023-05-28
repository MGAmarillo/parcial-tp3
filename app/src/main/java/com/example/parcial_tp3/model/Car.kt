package com.example.parcial_tp3.model

import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName(value = "city_mpg") val cityMpg: Int?,
    @SerializedName(value = "class") val type: String?,
    @SerializedName(value = "combination_mpg") val combinationMpg: Int?,
    val cylinders: Int?,
    val displacement: Double?,
    val drive: String?,
    @SerializedName(value = "fuel_type") val fuelType: String?,
    @SerializedName(value = "highway_mpg") val highwayMpg: Int?,
    val make: String?,
    val model: String?,
    val transmission: String?,
    val year: Int?,
)

package com.example.parcial_tp3.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CarServiceApiBuilder {
    private val BASE_URL = "https://api.api-ninjas.com/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(): CarService {
        return retrofit.create(CarService::class.java)
    }
}
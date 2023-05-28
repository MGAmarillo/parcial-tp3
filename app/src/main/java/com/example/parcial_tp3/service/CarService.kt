package com.example.parcial_tp3.service

import com.example.parcial_tp3.model.Car
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CarService {

    @GET("cars")
    fun getCars(@Header("x-api-key") apiKey: String, @Query("limit") limit:Int, @Query("make") make: String): Call<List<Car>>
}
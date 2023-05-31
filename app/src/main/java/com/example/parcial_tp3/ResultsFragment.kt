package com.example.parcial_tp3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3.model.Car
import com.example.parcial_tp3.service.CarServiceApiBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse
import java.util.concurrent.CopyOnWriteArrayList

class ResultsFragment : Fragment(){

    private lateinit var recyclerView: RecyclerView
    private lateinit var resultsAdapter: ResultsAdapter
    val carList: MutableList<Car> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_results, container, false)


        recyclerView = view.findViewById(R.id.recycler_results)
        resultsAdapter = ResultsAdapter(carList)
        recyclerView.adapter = resultsAdapter

        fetchData()

        return view
    }

    public fun fetchData() {
        val carService = CarServiceApiBuilder.create()

        val brands = listOf("Ford", "Nissan", "Fiat", "Volkswagen", "Renault", "Chevrolet", "Citroën", "Jeep")
        val totalBrands = brands.size

        val totalRequests = brands.size
        var completedRequests = 0

        val callback = object : Callback<List<Car>> {
            override fun onResponse(call: Call<List<Car>>, response: Response<List<Car>>) {
                if (response.isSuccessful) {
                    val newListCars = response.body()
                    newListCars?.let {
                        carList.addAll(it)
                    }
                } else {
                    // Manejo de errores
                    val errorBody = response.errorBody()
                    if (errorBody != null) {
                        val errorResponse = errorBody.string()
                        Log.e("Example", "Error: $errorResponse")
                    }
                }

                // Incrementar el contador de solicitudes completadas
                completedRequests++

                // Verificar si todas las solicitudes han sido completadas
                if (completedRequests == totalRequests) {
                    resultsAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<Car>>, t: Throwable) {
                // Manejo de errores
                Log.e("Example", t.stackTraceToString())

                // Incrementar el contador de solicitudes completadas
                completedRequests++

                // Verificar si todas las solicitudes han sido completadas
                if (completedRequests == totalRequests) {
                    resultsAdapter.notifyDataSetChanged()
                }
            }
        }

        val requests = brands.map { brand ->
            carService.getCarsByBrand("NG03oLP73APC3yQIqM67ng==QihXsJ0EWFQ7Dx0L", 50, brand)
        }

        requests.forEach { request ->
            request.enqueue(callback)
        }
    }

    public fun fetchDataByFuel() {
        val carService = CarServiceApiBuilder.create()

        val fuelType = "Electricity" // Tipo de combustible deseado
        val totalRequests = 1
        var completedRequests = 0

        val callback = object : Callback<List<Car>> {
            override fun onResponse(call: Call<List<Car>>, response: Response<List<Car>>) {
                if (response.isSuccessful) {
                    val newListCars = response.body()
                    newListCars?.let {
                        carList.addAll(it)
                    }
                } else {
                    // Manejo de errores
                    val errorBody = response.errorBody()
                    if (errorBody != null) {
                        val errorResponse = errorBody.string()
                        Log.e("Example", "Error: $errorResponse")
                    }
                }

                // Incrementar el contador de solicitudes completadas
                completedRequests++

                // Verificar si todas las solicitudes han sido completadas
                if (completedRequests == totalRequests) {
                    resultsAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<Car>>, t: Throwable) {
                // Manejo de errores
                Log.e("Example", t.stackTraceToString())

                // Incrementar el contador de solicitudes completadas
                completedRequests++

                // Verificar si todas las solicitudes han sido completadas
                if (completedRequests == totalRequests) {
                    resultsAdapter.notifyDataSetChanged()
                }
            }
        }

        val request = carService.getCarsByFuel("NG03oLP73APC3yQIqM67ng==QihXsJ0EWFQ7Dx0L", 50, fuelType)
        request.enqueue(callback)
    }


}

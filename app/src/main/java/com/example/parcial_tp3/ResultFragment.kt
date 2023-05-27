package com.example.parcial_tp3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.parcial_tp3.model.Car
import com.example.parcial_tp3.service.CarService
import com.example.parcial_tp3.service.CarServiceApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var dummyText: TextView
    private lateinit var carService: CarService
    private lateinit var carList: List<Car>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            // param1 = it.getString(ARG_PARAM1)
            //param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_home, container, false)
        carService = CarServiceApiBuilder.create()
        dummyText = v.findViewById(R.id.jsonResponseFromService)
        getCars("toyota")
        return v
    }


    fun getCars(make: String) {
        // sería ideal tener la apiKey como constante. El limit es la cantidad de resultados que trae.
        // el buscador va a funcionar por marca
        carService.getCars("By6cLo0+2UYM0MhxZf/xcw==SsuGcsRno38xPRrm",50, make).enqueue(object :
            Callback<List<Car>> {
            override fun onResponse(call: Call<List<Car>>, response: Response<List<Car>>) {
                if (response.isSuccessful) {
                    val cars = response.body()
                    dummyText.text = cars.toString()
                }
            }

            override fun onFailure(call: Call<List<Car>>, t: Throwable) {
                Log.e("Example", t.stackTraceToString())
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    // putString(ARG_PARAM1, param1)
                    // putString(ARG_PARAM2, param2)
                }
            }
    }
}
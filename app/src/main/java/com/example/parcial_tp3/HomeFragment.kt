package com.example.parcial_tp3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homeFragmentView = inflater.inflate(R.layout.fragment_home, container, false)

        val recycler = homeFragmentView.findViewById<RecyclerView>(R.id.recycler_brands)

        recycler.adapter = BrandsAdapter(listOf(
            Brand("https://logodownload.org/wp-content/uploads/2014/02/ford-logo-1-1.png","Ford","+50"),
            Brand("https://www.pnguniverse.com/wp-content/uploads/2020/10/Toyota.png","Toyota","+50"),
            Brand("https://logodownload.org/wp-content/uploads/2014/05/fiat-logo-21.png","Fiat","+50"),
            Brand("https://i0.wp.com/www.vectorizando.com/wp-content/uploads/2021/05/volkswagen-logo-f508905d.png?fit=500%2C500&ssl=1","Volkswagen","+50"),
            Brand("https://logodownload.org/wp-content/uploads/2014/09/renault-logo-2-1.png","Renault","+50"),
            Brand("https://es.logodownload.org/wp-content/uploads/2019/06/Chevrolet-logo-41.png","Chevrolet","+50"),
            Brand("https://logodownload.org/wp-content/uploads/2014/09/citroen-logo-1-1.png","Citroën","+50"),
            Brand("https://logodownload.org/wp-content/uploads/2014/09/nissan-logo-1-1.png","Nissan","+50"),
            Brand("https://segurovehicular.net/wp-content/uploads/2021/05/jeep-logo.png","Jeep","+50"),
        ))

        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        
        recycler.setLayoutManager(linearLayoutManager)
        

        return homeFragmentView
    }

}
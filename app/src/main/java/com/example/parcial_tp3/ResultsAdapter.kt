package com.example.parcial_tp3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parcial_tp3.model.Car

class ResultsAdapter(val cars: List<Car>) : RecyclerView.Adapter<ResultsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carName = itemView.findViewById<TextView>(R.id.titleCar)
        val carBrand = itemView.findViewById<TextView>(R.id.brand)
        val carTransmission = itemView.findViewById<TextView>(R.id.titleTransmission)
        val carFuel = itemView.findViewById<TextView>(R.id.titleFuel)
        val carYear = itemView.findViewById<TextView>(R.id.titleYear)
        val carSpecifics = itemView.findViewById<TextView>(R.id.titleSpecifics)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_results,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carName.setText(cars.get(position).model)
        holder.carBrand.setText(cars.get(position).make)
        holder.carTransmission.setText(cars.get(position).transmission)
        holder.carFuel.setText(cars.get(position).fuel_type)
        holder.carYear.setText(cars.get(position).year.toString())
        holder.carSpecifics.setText(cars.get(position).`class`)
    }


    fun updateData(filteredCars: List<Car>) {
        var carList = filteredCars
        notifyDataSetChanged()
        }

}
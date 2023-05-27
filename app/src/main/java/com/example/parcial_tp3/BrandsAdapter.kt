package com.example.parcial_tp3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BrandsAdapter(private val brands: List<Brand>) : RecyclerView.Adapter<BrandsAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val brandImage = view.findViewById<ImageView>(R.id.imageCardView)

        private val brandName = view.findViewById<TextView>(R.id.brand_name)

        private val count = view.findViewById<TextView>(R.id.result)

        fun bind(brand: Brand) {
            Glide.with(brandImage.context).load(brand.image).into(brandImage)
            brandName.text = brand.brandName
            count.text = brand.count
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = brands.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val brand = brands[position]
        holder.bind(brand)
    }




}
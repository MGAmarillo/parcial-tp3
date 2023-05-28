package com.example.parcial_tp3

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide

class BrandView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int
) : LinearLayout(context, attrs, defStyleAttr){
    private val brandImage : ImageView
    private val brandName : TextView
    private val count : TextView

    init{
        val view = LayoutInflater.from(context).inflate(R.layout.item_view_pager,this,true)

        brandImage = view.findViewById(R.id.imageCardView)

        brandName = view.findViewById(R.id.brand_name)

        count = view.findViewById(R.id.result)

        orientation = VERTICAL
    }

    fun setBrand(brand: Brand){
        Glide.with(context).load(brand.image).into(brandImage)
        brandName.text = brand.brandName
        count.text = brand.count
    }
}
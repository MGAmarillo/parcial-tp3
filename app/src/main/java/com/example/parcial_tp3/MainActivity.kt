package com.example.parcial_tp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        val hamburguerMenu = findViewById<ImageView>(R.id.imageMenu)
            hamburguerMenu.setOnClickListener(){
                drawerLayout.openDrawer(GravityCompat.START)
            }
        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        navigationView.itemIconTintList = null
    }
}
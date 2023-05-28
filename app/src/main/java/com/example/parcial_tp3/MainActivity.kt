package com.example.parcial_tp3

import android.annotation.SuppressLint
import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.parcial_tp3.model.Car
import com.example.parcial_tp3.service.CarService
import com.example.parcial_tp3.service.CarServiceApiBuilder
import com.google.android.material.navigation.NavigationView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarItemView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    
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

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottomMenuHome -> {
                    if(this.findNavController(R.id.navHostFragment).currentDestination?.id != R.id.homeFragment){
                        if(this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.profileFragment){
                            val actionProfileToHome = ProfileFragmentDirections.actionProfileFragmentToHomeFragment()
                            this.findNavController(R.id.navHostFragment).navigate(actionProfileToHome)
                        }
                        if(this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.resultsFragment){
                            val actionResultsToHome = ResultsFragmentDirections.actionResultsFragmentToHomeFragment()
                            this.findNavController(R.id.navHostFragment).navigate(actionResultsToHome)
                        }


                    }
                    true
                }
                R.id.bottomMenuAutos -> {
                    if(this.findNavController(R.id.navHostFragment).currentDestination?.id != R.id.resultsFragment) {

                        if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.homeFragment) {
                            val actionHomeToResults =
                                HomeFragmentDirections.actionHomeFragmentToResultFragment()
                            this.findNavController(R.id.navHostFragment)
                                .navigate(actionHomeToResults)
                        }

                        if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.profileFragment) {
                            val actionProfileToResults =
                                ProfileFragmentDirections.actionProfileFragmentToResultsFragment()
                            this.findNavController(R.id.navHostFragment)
                                .navigate(actionProfileToResults)
                        }
                    }
                    true
                }
                R.id.bottomMenuBuscar -> {
                    if(this.findNavController(R.id.navHostFragment).currentDestination?.id != R.id.resultsFragment) {

                        if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.homeFragment) {
                            val actionHomeToResults =
                                HomeFragmentDirections.actionHomeFragmentToResultFragment()
                            this.findNavController(R.id.navHostFragment)
                                .navigate(actionHomeToResults)
                        }

                        if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.profileFragment) {
                            val actionProfileToResults =
                                ProfileFragmentDirections.actionProfileFragmentToResultsFragment()
                            this.findNavController(R.id.navHostFragment)
                                .navigate(actionProfileToResults)
                        }
                    }

                    true
                }
                R.id.bottomMenuPerfil -> {

                    if(this.findNavController(R.id.navHostFragment).currentDestination?.id != R.id.profileFragment){

                        if(this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.homeFragment){
                            val actionHomeToProfile = HomeFragmentDirections.actionHomeFragmentToProfileFragment()
                            this.findNavController(R.id.navHostFragment).navigate(actionHomeToProfile)
                        }
                        if(this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.resultsFragment){
                            val actionResultsToProfile = ResultsFragmentDirections.actionResultsFragmentToProfileFragment()
                            this.findNavController(R.id.navHostFragment).navigate(actionResultsToProfile)
                        }


                    }
                    true
                }
                else -> false
            }
        }



    }

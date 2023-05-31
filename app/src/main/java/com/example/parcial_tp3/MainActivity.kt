package com.example.parcial_tp3

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import okhttp3.internal.http2.Header


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = intent

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        val hamburguerMenu = findViewById<ImageView>(R.id.imageMenu)

        hamburguerMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        navigationView.itemIconTintList = null

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottomMenuHome -> {
                    if (this.findNavController(R.id.navHostFragment).currentDestination?.id != R.id.homeFragment) {
                        if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.profileFragment) {
                            val actionProfileToHome =
                                ProfileFragmentDirections.actionProfileFragmentToHomeFragment()
                            this.findNavController(R.id.navHostFragment)
                                .navigate(actionProfileToHome)
                        }
                        if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.resultsFragment) {
                            val actionResultsToHome =
                                ResultsFragmentDirections.actionResultsFragmentToHomeFragment()
                            this.findNavController(R.id.navHostFragment)
                                .navigate(actionResultsToHome)
                        }

                        if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.configurationFragment) {
                            val actionConfigurationToHome =
                                ConfigurationFragmentDirections.actionConfigurationFragmentToHomeFragment()
                            this.findNavController(R.id.navHostFragment)
                                .navigate(actionConfigurationToHome)
                        }
                    }
                    true
                }

                R.id.bottomMenuAutos -> {
                    if (this.findNavController(R.id.navHostFragment).currentDestination?.id != R.id.resultsFragment) {
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

                        if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.configurationFragment) {
                            val actionConfigurationToResults =
                                ConfigurationFragmentDirections.actionConfigurationFragmentToResultsFragment()
                            this.findNavController(R.id.navHostFragment)
                                .navigate(actionConfigurationToResults)
                        }
                    }
                    true
                }

                R.id.bottomMenuBuscar -> {
                    if (this.findNavController(R.id.navHostFragment).currentDestination?.id != R.id.resultsFragment) {
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

                        if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.configurationFragment) {
                            val actionConfigurationToResults =
                                ConfigurationFragmentDirections.actionConfigurationFragmentToResultsFragment()
                            this.findNavController(R.id.navHostFragment)
                                .navigate(actionConfigurationToResults)
                        }
                    }
                    true
                }

                R.id.bottomMenuPerfil -> {
                    if (this.findNavController(R.id.navHostFragment).currentDestination?.id != R.id.profileFragment) {
                        if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.homeFragment) {
                            val actionHomeToProfile =
                                HomeFragmentDirections.actionHomeFragmentToProfileFragment()
                            this.findNavController(R.id.navHostFragment)
                                .navigate(actionHomeToProfile)
                        }
                        if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.resultsFragment) {
                            val actionResultsToProfile =
                                ResultsFragmentDirections.actionResultsFragmentToProfileFragment()
                            this.findNavController(R.id.navHostFragment)
                                .navigate(actionResultsToProfile)
                        }
                        if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.configurationFragment) {
                            val actionConfigurationToProfile =
                                ConfigurationFragmentDirections.actionConfigurationFragmentToProfileFragment()
                            this.findNavController(R.id.navHostFragment)
                                .navigate(actionConfigurationToProfile)
                        }
                        true
                    } else {
                        false
                    }
                }
                else -> false
            }
        }

        navigationView.setNavigationItemSelectedListener(this)

        val headerView = navigationView.getHeaderView(0)

        val textoPerfilHeader = headerView.findViewById<TextView>(R.id.nombrePerfil)

        val bundle = intent.extras

        val textoRecibido = bundle?.getString("textoExtra")

        if (bundle != null && bundle.containsKey("textoExtra")) {
            textoPerfilHeader.text = textoRecibido
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuProfile -> {
                if (this.findNavController(R.id.navHostFragment).currentDestination?.id != R.id.profileFragment) {
                    if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.homeFragment) {
                        val actionHomeToProfile =
                            HomeFragmentDirections.actionHomeFragmentToProfileFragment()
                        this.findNavController(R.id.navHostFragment)
                            .navigate(actionHomeToProfile)
                    }
                    if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.resultsFragment) {
                        val actionResultsToProfile =
                            ResultsFragmentDirections.actionResultsFragmentToProfileFragment()
                        this.findNavController(R.id.navHostFragment)
                            .navigate(actionResultsToProfile)
                    }

                    if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.configurationFragment) {
                        val actionConfigurationToProfile =
                            ConfigurationFragmentDirections.actionConfigurationFragmentToProfileFragment()
                        this.findNavController(R.id.navHostFragment)
                            .navigate(actionConfigurationToProfile)
                    }

                }
                return true
            }

            R.id.menuSettings -> {
                if (this.findNavController(R.id.navHostFragment).currentDestination?.id != R.id.configurationFragment) {
                    if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.homeFragment) {
                        val actionHomeToConfiguration =
                            HomeFragmentDirections.actionHomeFragmentToConfigurationsFragment()
                        this.findNavController(R.id.navHostFragment)
                            .navigate(actionHomeToConfiguration)
                    }
                    if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.resultsFragment) {
                        val actionResultsToConfiguration =
                            ResultsFragmentDirections.actionResultsFragmentToConfigurationsFragment()
                        this.findNavController(R.id.navHostFragment)
                            .navigate(actionResultsToConfiguration)
                    }

                    if (this.findNavController(R.id.navHostFragment).currentDestination?.id == R.id.profileFragment) {
                        val actionProfileToConfiguration =
                            ProfileFragmentDirections.actionProfileFragmentToConfigurationsFragment()
                        this.findNavController(R.id.navHostFragment)
                            .navigate(actionProfileToConfiguration)
                    }
                    return true
                }
            }
        }
        return false
    }
}


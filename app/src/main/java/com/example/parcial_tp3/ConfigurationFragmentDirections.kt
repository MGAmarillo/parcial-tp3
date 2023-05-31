package com.example.parcial_tp3

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

class ConfigurationFragmentDirections private constructor() {
    public companion object {
        public fun actionConfigurationFragmentToHomeFragment(): NavDirections =
            ActionOnlyNavDirections(R.id.action_configurationFragment_to_homeFragment)

        public fun actionConfigurationFragmentToProfileFragment(): NavDirections =
            ActionOnlyNavDirections(R.id.action_configurationFragment_to_profileFragment)

        public fun actionConfigurationFragmentToResultsFragment(): NavDirections =
            ActionOnlyNavDirections(R.id.action_configurationFragment_to_resultsFragment)
    }
}
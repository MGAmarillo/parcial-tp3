package com.example.parcial_tp3

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

class HomeFragmentDirections private constructor() {
    public companion object {
        public fun actionHomeFragmentToProfileFragment(): NavDirections =
            ActionOnlyNavDirections(R.id.action_homeFragment_to_profileFragment)

        public fun actionHomeFragmentToResultFragment(): NavDirections =
            ActionOnlyNavDirections(R.id.action_homeFragment_to_resultsFragment)
    }
}

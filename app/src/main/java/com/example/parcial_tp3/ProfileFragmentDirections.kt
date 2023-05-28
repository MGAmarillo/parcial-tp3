package com.example.parcial_tp3

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

class ProfileFragmentDirections private constructor() {
    public companion object {
        public fun actionProfileFragmentToHomeFragment(): NavDirections =
            ActionOnlyNavDirections(R.id.action_profileFragment_to_homeFragment)

        public fun actionProfileFragmentToResultsFragment(): NavDirections =
            ActionOnlyNavDirections(R.id.action_profileFragment_to_resultsFragment)
    }
}
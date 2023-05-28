package com.example.parcial_tp3

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

class ResultsFragmentDirections private constructor() {
        public companion object {
            public fun actionResultsFragmentToHomeFragment(): NavDirections =
                ActionOnlyNavDirections(R.id.action_resultsFragment_to_homeFragment)

            public fun actionResultsFragmentToProfileFragment(): NavDirections =
                ActionOnlyNavDirections(R.id.action_resultsFragment_to_profileFragment)
        }
    }
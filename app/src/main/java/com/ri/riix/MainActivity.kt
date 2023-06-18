package com.ri.riix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ri.riix.navigation.ConnectScreenDestination
import com.ri.riix.navigation.CreatePlanScreenDestination
import com.ri.riix.navigation.HomeScreenDestination
import com.ri.riix.navigation.WorkoutScreenDestination
import com.ri.riix.ui.theme.RiixTheme
import dagger.hilt.android.AndroidEntryPoint
import no.nordicsemi.android.common.navigation.NavigationView

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RiixTheme() {
                // A surface container using the 'background' color from the theme
                NavigationView(
                    destinations = listOf(/*LoginScreenDestination,*/HomeScreenDestination,
                        CreatePlanScreenDestination, ConnectScreenDestination,
                        WorkoutScreenDestination
                    )
                )
            }
        }
    }
}
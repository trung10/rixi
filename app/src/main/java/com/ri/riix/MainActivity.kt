package com.ri.riix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ri.riix.navigation.HomeScreenDestination
import com.ri.riix.navigation.LoginScreenDestination
import com.ri.riix.ui.theme.RiixTheme
import dagger.hilt.android.AndroidEntryPoint
import no.nordicsemi.android.common.navigation.NavigationView
import no.nordicsemi.android.common.theme.NordicTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RiixTheme() {
                // A surface container using the 'background' color from the theme
                NavigationView(
                    destinations = listOf(/*LoginScreenDestination,*/HomeScreenDestination)
                )
            }
        }
    }
}
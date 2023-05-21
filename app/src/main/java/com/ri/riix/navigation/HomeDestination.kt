package com.ri.riix.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import com.ri.riix.screen.HomeScreen
import com.ri.riix.screen.LoginScreen
import no.nordicsemi.android.common.navigation.createSimpleDestination
import no.nordicsemi.android.common.navigation.defineDestination
import no.nordicsemi.android.common.navigation.viewmodel.SimpleNavigationViewModel

val HomeDestination = createSimpleDestination(NavigationConst.HOME)
private val Home = defineDestination(HomeDestination) {
    val viewModel: SimpleNavigationViewModel = hiltViewModel()

    HomeScreen(
        onServerNavigation = {/*viewModel.navigateTo(ServerDestination)*/}
    )
}
val HomeScreenDestination = Home
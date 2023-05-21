package com.ri.riix.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import com.ri.riix.screen.LoginScreen
import no.nordicsemi.android.common.navigation.createSimpleDestination
import no.nordicsemi.android.common.navigation.defineDestination
import no.nordicsemi.android.common.navigation.viewmodel.SimpleNavigationViewModel

val LoginDestination = createSimpleDestination(NavigationConst.LOGIN)
private val Start = defineDestination(LoginDestination) {
    val viewModel: SimpleNavigationViewModel = hiltViewModel()

    LoginScreen(
        onServerNavigation = {viewModel.navigateTo(HomeDestination)},
        onClientNavigation =  {/*viewModel.navigateTo(ClientDestination)*/},
    )
}
val LoginScreenDestination = Start
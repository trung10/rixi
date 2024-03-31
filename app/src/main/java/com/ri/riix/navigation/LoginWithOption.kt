package com.ri.riix.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import com.ri.riix.screen.LoginScreen
import com.ri.riix.screen.LoginWithOptionScreen
import no.nordicsemi.android.common.navigation.createSimpleDestination
import no.nordicsemi.android.common.navigation.defineDestination
import no.nordicsemi.android.common.navigation.viewmodel.SimpleNavigationViewModel

val LoginWithOptionDestination = createSimpleDestination(NavigationConst.LOGIN)
private val Start = defineDestination(LoginWithOptionDestination) {
    val viewModel: SimpleNavigationViewModel = hiltViewModel()

    LoginWithOptionScreen(
        onLogin = {viewModel.navigateTo(HomeDestination)},
        onLoginApple =  {/*viewModel.navigateTo(ClientDestination)*/},
        onLoginFacebook = { },
        onLoginGoogle = { }
    )
}
val LoginWithOptionScreenDestination = Start
package com.ri.riix.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import com.ri.riix.screen.device.ConnectDeviceScreen
import com.ri.riix.screen.device.WorkOutScreen
import no.nordicsemi.android.common.navigation.createSimpleDestination
import no.nordicsemi.android.common.navigation.defineDestination
import no.nordicsemi.android.common.navigation.viewmodel.SimpleNavigationViewModel

val ConnectDeviceDestination = createSimpleDestination(NavigationConst.DEVICE)
private val connectDevice = defineDestination(ConnectDeviceDestination) {
    val viewModel: SimpleNavigationViewModel = hiltViewModel()

    ConnectDeviceScreen(
        onNextNavigation = {viewModel.navigateTo(WorkOutDestination) },
        onBack = {}
    )
}
val ConnectScreenDestination = connectDevice



val WorkOutDestination = createSimpleDestination(NavigationConst.WORKOUT)
private val workout = defineDestination(WorkOutDestination) {
    val viewModel: SimpleNavigationViewModel = hiltViewModel()

    WorkOutScreen(
        onNextNavigation = {/*viewModel.navigateTo(ServerDestination)*/ },
        onBack = {}
    )
}
val WorkoutScreenDestination = workout



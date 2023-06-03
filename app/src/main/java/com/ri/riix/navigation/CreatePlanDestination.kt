package com.ri.riix.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import com.ri.riix.screen.HomeScreen
import com.ri.riix.screen.device.ConnectDeviceScreen
import com.ri.riix.screen.plan.CreatePlanScreen
import no.nordicsemi.android.common.navigation.createSimpleDestination
import no.nordicsemi.android.common.navigation.defineDestination
import no.nordicsemi.android.common.navigation.viewmodel.SimpleNavigationViewModel


val DeviceDestination = createSimpleDestination(NavigationConst.DEVICE)
private val Device = defineDestination(DeviceDestination) {
    val viewModel: SimpleNavigationViewModel = hiltViewModel()

    ConnectDeviceScreen (
        onNextNavigation = {/*viewModel.navigateTo(ServerDestination)*/},
        onBack = {}
    )
}
val DeviceScreenDestination = Device
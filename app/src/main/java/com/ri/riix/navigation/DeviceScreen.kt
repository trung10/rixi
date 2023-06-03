package com.ri.riix.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import com.ri.riix.screen.device.ConnectDeviceScreen
import no.nordicsemi.android.common.navigation.createSimpleDestination
import no.nordicsemi.android.common.navigation.defineDestination
import no.nordicsemi.android.common.navigation.viewmodel.SimpleNavigationViewModel

val CreatePlanDestination = createSimpleDestination(NavigationConst.CREATE_PLAN)
private val CreatePlan = defineDestination(CreatePlanDestination) {
    val viewModel: SimpleNavigationViewModel = hiltViewModel()

    ConnectDeviceScreen(
        onNextNavigation = {/*viewModel.navigateTo(ServerDestination)*/ },
        onBack = {}
    )
}
val CreatePlanScreenDestination = CreatePlan
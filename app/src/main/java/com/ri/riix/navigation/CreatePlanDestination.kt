package com.ri.riix.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import com.ri.riix.screen.HomeScreen
import com.ri.riix.screen.device.ConnectDeviceScreen
import com.ri.riix.screen.plan.ChooseWorkout
import com.ri.riix.screen.plan.CreatePlanScreen
import no.nordicsemi.android.common.navigation.createSimpleDestination
import no.nordicsemi.android.common.navigation.defineDestination
import no.nordicsemi.android.common.navigation.viewmodel.SimpleNavigationViewModel


val CreatePlanDestination = createSimpleDestination(NavigationConst.CREATE_PLAN)
private val Device = defineDestination(CreatePlanDestination) {
    val viewModel: SimpleNavigationViewModel = hiltViewModel()

    ChooseWorkout (
        onNextNavigation = {viewModel.navigateTo(ConnectDeviceDestination)},
        onBack = {}
    )
}
val CreatePlanScreenDestination = Device
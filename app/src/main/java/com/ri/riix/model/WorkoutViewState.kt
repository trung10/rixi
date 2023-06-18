package com.ri.riix.model

import kotlinx.coroutines.flow.StateFlow
import no.nordicsemi.android.ble.ktx.state.ConnectionState


data class WorkoutViewState(
    val state: ConnectionState = ConnectionState.Initializing,
    val exerciseState: EXC_STATE? = null,
    val nameExercise: String? = null,
    val currentRep: Int? = null,
    val totalRep: Int? = null,
    val currentSet: Int? = null,
    val totalSet: Int? = null,
    val ticks: StateFlow<Int>? = null,
    val isFinish: Boolean? = null,
    //val result: Results? = null,
    val isError: Error? = null,
    //val isUserTyping: Boolean = false,
    //val userRequestedPlayersNameDialog: Boolean = true
) {
    val isTimerRunning: Boolean = ticks?.value?.let { it > 0 } == true

    //val isDuplicate: Boolean = isError?.isDuplicateName ?: false

    //val openDialog: Boolean = isError?.isError() ?: true

}

enum class EXC_STATE {
    START,
    WORKOUT,
    REST
}

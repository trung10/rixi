package com.ri.riix.screen.device

import android.Manifest
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewModelScope
import com.ri.riix.ble.BleConnectionManager
import com.ri.riix.ble.ConnectionInf
import com.ri.riix.ble.Scanner
import com.ri.riix.core.Exercise
import com.ri.riix.core.TimerViewModel
import com.ri.riix.core.WorkoutRep
import com.ri.riix.model.COMMAND
import com.ri.riix.model.Data
import com.ri.riix.model.EXC_STATE
import com.ri.riix.model.WorkoutViewState
import com.ri.riix.utils.toCommand
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import no.nordicsemi.android.ble.ktx.state.ConnectionState
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val scanner: Scanner
) : TimerViewModel() {
    private val TAG = WorkoutViewModel::class.java.simpleName
    private var device: BluetoothDevice? = null
    private var plan = Data.sample
    private var exercise = plan.list.first()
    private var workoutEngine = WorkoutRep("", Exercise.FlyCable)

    private val _workoutState: MutableStateFlow<WorkoutViewState> =
        MutableStateFlow(WorkoutViewState())
    val workoutState = _workoutState.asStateFlow()

    private var bleConnection: ConnectionInf? = null

    init {
        Log.d(TAG, "init entry")
    }

    fun scan(onConnected: () -> Unit) {
        Log.d(TAG, "scan entry")

        viewModelScope.launch(Dispatchers.IO) {
            device = scanner.searchForNewDevice()

            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                Log.d(TAG, "Name: ${device?.name}")
            }

            Log.d(TAG, "Address: ${device?.address}")

            onConnected.invoke()

            device?.let {
                bleConnection =
                    BleConnectionManager(context = context, scope = this, device = it).apply {
                        connect()
                    }
            }
        }
    }

    private fun readState() {
        bleConnection?.readState { state ->

            if (_workoutState.value.exerciseState == EXC_STATE.WORKOUT)
                workoutEngine.newState(state) {
                    Log.d(TAG, "new rep")

                    if (_workoutState.value.currentSet!! >= _workoutState.value.totalSet!!) {
                        if (exercise.name != "Squad") {
                            if (_workoutState.value.currentRep!! >= _workoutState.value.totalRep!!) {
                                // new exercise
                                startNewWorkout()
                                exercise = plan.list.last()
                                workoutEngine.exercise = Exercise.Squad
                                startCountDown(plan.restPeriodsBetweenExercises)

                                _workoutState.value = _workoutState.value.copy(
                                    state = ConnectionState.Ready,
                                    nameExercise = exercise.name,
                                    exerciseState = EXC_STATE.START,
                                    currentRep = 0,
                                    totalRep = exercise.rep,
                                    currentSet = 0,
                                    totalSet = exercise.set,
                                    //ticks = ticks,
                                    isFinish = false,
                                    isError = null
                                )
                            } else {
                                _workoutState.value = _workoutState.value.copy(
                                    currentRep = _workoutState.value.currentRep!! + 1
                                )

                                Log.d(TAG, "currentRep 1: ${_workoutState.value.currentRep}")

                                if (_workoutState.value.currentRep!! >= _workoutState.value.totalRep!!) {
                                    viewModelScope.launch {
                                        delay(500)
                                        // new exercise
                                        startNewWorkout()
                                        exercise = plan.list.last()
                                        workoutEngine.exercise = Exercise.Squad
                                        startCountDown(plan.restPeriodsBetweenExercises)

                                        _workoutState.value = _workoutState.value.copy(
                                            state = ConnectionState.Ready,
                                            nameExercise = exercise.name,
                                            exerciseState = EXC_STATE.START,
                                            currentRep = 0,
                                            totalRep = exercise.rep,
                                            currentSet = 0,
                                            totalSet = exercise.set,
                                            //ticks = ticks,
                                            isFinish = false,
                                            isError = null
                                        )
                                    }
                                }
                            }
                        } else {
                            if (_workoutState.value.currentRep!! >= _workoutState.value.totalRep!!){
                                _workoutState.value = _workoutState.value.copy(
                                    isFinish = true
                                )
                            } else {
                                _workoutState.value = _workoutState.value.copy(
                                    currentRep = _workoutState.value.currentRep!! + 1
                                )

                                Log.d(TAG, "currentRep 2: ${_workoutState.value.currentRep}")

                                if (_workoutState.value.currentRep!! >= _workoutState.value.totalRep!!) {
                                    viewModelScope.launch {
                                        delay(500)
                                        _workoutState.value = _workoutState.value.copy(
                                            //ticks = ticks,
                                            isFinish = true
                                        )
                                    }
                                }
                            }
                        }
                    } else if (_workoutState.value.currentRep!! >= _workoutState.value.totalRep!!) {
                        startCountDown(plan.restPeriodBetweenSets)
                        _workoutState.value = _workoutState.value.copy(
                            state = ConnectionState.Ready,
                            nameExercise = exercise.name,
                            exerciseState = EXC_STATE.REST,
                            totalRep = exercise.rep,
                            totalSet = exercise.set,
                            //ticks = ticks,
                            isFinish = false,
                            isError = null
                        )
                    } else {
                        //startCountDown(plan.warningTimeBeforeStartOfEachSet)
                        _workoutState.value = _workoutState.value.copy(
                            currentRep = _workoutState.value.currentRep!! + 1
                        )

                        Log.d(TAG, "currentRep 3: ${_workoutState.value.currentRep}")

                        if (_workoutState.value.currentRep!! >= _workoutState.value.totalRep!!) {
                            viewModelScope.launch {
                                delay(500)
                                startCountDown(plan.restPeriodBetweenSets)
                                _workoutState.value = _workoutState.value.copy(
                                    exerciseState = EXC_STATE.REST
                                )
                            }

                        }
                    }

                }
        }
    }

    private fun startNewWorkout() {
        viewModelScope.launch {
            delay(1000)
            bleConnection?.sendData(COMMAND.SS_SET_CAL.toCommand().toByteArray())
        }
    }

    private var coroutineScope: CoroutineScope? = null
    private fun readInterval() {

        if (coroutineScope == null)
            coroutineScope = CoroutineScope(SupervisorJob())
        else
            return

        val job = coroutineScope?.launch {
            delay(2000)
            val job = interval(1, TimeUnit.SECONDS)
                .onStart {
                    emit(-1)
                }
                .onEach {
                    Log.d(TAG, "time: $it")
                    readState()
                }
                .map {
                    "Current time $it"
                }
                .launchIn(coroutineScope!!)
        }
    }

    private fun interval(timeInMillis: Long, timeUnit: TimeUnit): Flow<Long> = flow {
        var counter: Long = 0
        val delayTime = when (timeUnit) {
            TimeUnit.MICROSECONDS -> timeInMillis / 1000
            TimeUnit.NANOSECONDS -> timeInMillis / 1_000_000
            TimeUnit.SECONDS -> timeInMillis * 1000
            TimeUnit.MINUTES -> 60 * timeInMillis * 1000
            TimeUnit.HOURS -> 60 * 60 * timeInMillis * 1000
            TimeUnit.DAYS -> 24 * 60 * 60 * timeInMillis * 1000
            else -> timeInMillis
        }

        while (true) {
            delay(delayTime)
            emit(counter++)
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope?.cancel()
        bleConnection?.release()
    }

    fun startWorkout() {
        startNewWorkout()
        readInterval()
        //startCountDown(Timer.MINUTE_10S_TIME)

        // first set
        _workoutState.value = _workoutState.value.copy(
            state = ConnectionState.Ready,
            nameExercise = exercise.name,
            exerciseState = EXC_STATE.WORKOUT,
            currentRep = 0,
            totalRep = exercise.rep,
            currentSet = 1,
            totalSet = exercise.set,
            //ticks = ticks,
            isFinish = false,
            isError = null
        )

        timerFinished.onEach {
            Log.d(TAG, "timerFinished is finished")

            if (_workoutState.value.currentSet!! >= _workoutState.value.totalSet!!) {
                if (exercise.name != "Squad") {
                    // new exercise
                    //exercise = plan.list.last()
                    //startCountDown(plan.restPeriodsBetweenExercises)

                    _workoutState.value = _workoutState.value.copy(
                        state = ConnectionState.Ready,
                        nameExercise = exercise.name,
                        exerciseState = EXC_STATE.WORKOUT,
                        currentRep = 0,
                        totalRep = exercise.rep,
                        currentSet = 1,
                        totalSet = exercise.set,
                        //ticks = ticks,
                        isFinish = false,
                        isError = null
                    )
                } else {
                    /*_workoutState.value = _workoutState.value.copy(
                        state = ConnectionState.Ready,
                        nameExercise = exercise.name,
                        exerciseState = EXC_STATE.START,
                        currentRep = exercise.rep,
                        totalRep = exercise.rep,
                        currentSet = exercise.set,
                        totalSet = exercise.set,
                        //ticks = ticks,
                        isFinish = true,
                        isError = null
                    )*/
                }
            } else /*if (_workoutState.value.currentRep!! >= _workoutState.value.totalRep!!)*/ {
                //startCountDown(plan.restPeriodBetweenSets)
                _workoutState.value = _workoutState.value.copy(
                    state = ConnectionState.Ready,
                    nameExercise = exercise.name,
                    exerciseState = EXC_STATE.WORKOUT,
                    currentRep = 0,
                    totalRep = exercise.rep,
                    currentSet = _workoutState.value.currentSet!! +1,
                    totalSet = exercise.set,
                    //ticks = ticks,
                    isFinish = false,
                    isError = null
                )
            }/* else {
                _workoutState.value = _workoutState.value.copy(
                    state = ConnectionState.Ready,
                    nameExercise = exercise.name,
                    exerciseState = EXC_STATE.WORKOUT,
                    currentRep = +1,
                    totalRep = exercise.rep,
                    totalSet = exercise.set,
                    //ticks = ticks,
                    isFinish = false,
                    isError = null
                )
            }*/

        }.launchIn(scope = viewModelScope)

    }
}
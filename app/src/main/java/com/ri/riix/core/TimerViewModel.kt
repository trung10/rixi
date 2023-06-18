package com.ri.riix.core

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ri.riix.core.Timer.MINUTE_30S_TIME
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

object Timer {
    const val MINUTE_30S_TIME = 30
    const val MINUTE_10S_TIME = 10
}

open class TimerViewModel: ViewModel() {
    private var _ticks = MutableStateFlow(Timer.MINUTE_10S_TIME)
    val ticks = _ticks.asStateFlow()

    private var _total = MutableStateFlow(Timer.MINUTE_10S_TIME)
    val total = _total.asStateFlow()

    val timerFinished = _ticks.transform { value ->
        if (value == 0) {
            emit(Unit)
        }
    }

    fun startCountDown(seconds: Int = MINUTE_30S_TIME) {
        _ticks.value = seconds
        _total.value = seconds

        viewModelScope.launch {
            _ticks.value = seconds

            while (_ticks.value > 0) {
                delay(1.seconds)
                _ticks.value -= 1
            }
        }
    }
}
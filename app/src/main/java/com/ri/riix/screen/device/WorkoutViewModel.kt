package com.ri.riix.screen.device

import android.Manifest
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewModelScope
import com.ri.riix.ble.BleConnectionManager
import com.ri.riix.ble.Scanner
import com.ri.riix.core.TimerViewModel
import com.ri.riix.model.Data
import com.ri.riix.model.Exercise
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val scanner: Scanner
) : TimerViewModel() {
    private val TAG = WorkoutViewModel::class.java.simpleName
    private var device: BluetoothDevice? = null
    private var plan = Data.sample
    lateinit var current: MutableState<Exercise>

    init {
        Log.d(TAG, "init entry")
        current.value = plan.list.first()
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

            with(Dispatchers.Main){
                onConnected.invoke()
            }

            device?.let {
                BleConnectionManager(context = context, scope = this, device = it).apply {
                    connect()
                }
            }
        }
    }

    fun listenData() {

    }
}
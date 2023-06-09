package com.ri.riix.ble

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanFilter
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class Scanner @Inject constructor(
    @ApplicationContext val context: Context,
    bluetoothAdapter: BluetoothAdapter
) {

    private val bluetoothLeScanner: BluetoothLeScanner by lazy {
        bluetoothAdapter.bluetoothLeScanner
            ?: throw NullPointerException("Bluetooth not initialized")
    }

    /**
     * Starts scanning for an advertising server.
     * Returns the first found device.
     */
    @SuppressLint("MissingPermission")
    suspend fun searchForNewDevice(): BluetoothDevice =
        suspendCancellableCoroutine { continuation ->

            val callback = object : ScanCallback() {
                override fun onScanResult(callbackType: Int, result: ScanResult?) {
                    result
                        ?.let { continuation.resume(it.device) }
                        .also { bluetoothLeScanner.stopScan(this) }
                }

                override fun onScanFailed(errorCode: Int) {
                    continuation.resumeWithException(ScanningException(errorCode))
                }
            }
            continuation.invokeOnCancellation {
                bluetoothLeScanner.stopScan(callback)
            }

            val scanSettings = ScanSettings.Builder()
                .setReportDelay(0) // Set to 0 to be notified of scan results immediately.
                .setScanMode(ScanSettings.SCAN_MODE_LOW_POWER)
                .build()

            val scanFilters = listOf(
                ScanFilter.Builder()
                    //.setServiceUuid(ParcelUuid(UUID.fromString(UUID_SERVICE_DEVICE)))
                    .setDeviceName("Counter Device")
                    .build()
            )

            bluetoothLeScanner.startScan(
                scanFilters,
                scanSettings,
                callback
            )
        }
}

data class ScanningException(val errorCode: Int) : Exception()
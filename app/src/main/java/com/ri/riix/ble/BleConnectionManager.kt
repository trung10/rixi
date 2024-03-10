package com.ri.riix.ble

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.ri.riix.model.Data.UUID_MSG_CHARACTERISTIC
import com.ri.riix.model.Data.UUID_SERVICE_DEVICE
import com.ri.riix.utils.PacketSplitter
import com.ri.riix.utils.toUUID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import no.nordicsemi.android.ble.BleManager
import no.nordicsemi.android.ble.ktx.asFlow
import no.nordicsemi.android.ble.ktx.suspend

class BleConnectionManager(
    private val scope: CoroutineScope,
    context: Context,
    val device: BluetoothDevice
) : ConnectionInf, BleManager(context) {
    private val TAG = BleConnectionManager::class.java.simpleName
    var characteristic: BluetoothGattCharacteristic? = null

    private val _deviceData = MutableSharedFlow<String>()
    val deviceData = _deviceData.asSharedFlow()

    @SuppressLint("MissingPermission")
    override fun isRequiredServiceSupported(gatt: BluetoothGatt): Boolean {
        Log.d(TAG, "isRequiredServiceSupported entry")
        gatt.getService(UUID_SERVICE_DEVICE.toUUID())?.let { service ->
            characteristic = service.getCharacteristic(UUID_MSG_CHARACTERISTIC.toUUID())

            gatt.setCharacteristicNotification(characteristic, true)
        }

        Log.d(TAG, "isRequiredServiceSupported boolean: ${characteristic != null}")

        return characteristic != null
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun initialize() {
        super.initialize()
        Log.d(TAG, "initialize entry")
        requestMtu(512).enqueue() // request Mtu-512

        setNotificationCallback(characteristic)
            // Merges packets until the entire text is present in the stream [PacketMerger.merge].
            //.merge(PacketMerger())
            .asFlow()
            .onEach {
                it.getStringValue(0)?.let {
                    _deviceData.emit(it)
                }
            }
            .launchIn(scope)


        enableNotifications(characteristic).enqueue()

        startReadInterval()
    }

    override fun onServicesInvalidated() {
        characteristic = null
    }

    private fun isSupportNotification(chrs: BluetoothGattCharacteristic?): Boolean {
        if (chrs == null) return false
        val canNotify = chrs.properties and BluetoothGattCharacteristic.PROPERTY_NOTIFY != 0
        if (!canNotify)
            log(Log.WARN, "Characteristic ${chrs.uuid} doesn't support notification")
        return canNotify
    }

    suspend fun connect() {
        connect(device)
            .retry(4, 300)
            .useAutoConnect(false)
            .timeout(100_000)
            .suspend()
    }

    override fun startReadInterval() {
        scope.launch {

        }
    }

    override suspend fun sendData(data: ByteArray) {
        Log.d(TAG, "SendData: " + String(data, Charsets.UTF_8))
        writeCharacteristic(
            characteristic,
            data,
            BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
        ).split(PacketSplitter()).suspend()
    }

    override suspend fun sendDataNoReturn(data: ByteArray) {
        writeCharacteristic(
            characteristic,
            data,
            BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
        ).split(PacketSplitter()).enqueue()
    }

    override fun scanDevice(): BluetoothDevice {
        TODO("Not yet implemented")
    }

    override fun pairDevice() {
        TODO("Not yet implemented")
    }

    override fun readState(state: (String) -> Unit) {
        readCharacteristic(characteristic).with { _, data ->
            Log.d(TAG, "readState data: ${String(data.value!!, Charsets.UTF_8)}")
            state.invoke(String(data.value!!, Charsets.UTF_8))
        }.enqueue()
    }

    override fun log(priority: Int, message: String) {
        Log.d("BleManager", message)
    }

    override fun release() {
        cancelQueue()
        disconnect().enqueue()
    }
}
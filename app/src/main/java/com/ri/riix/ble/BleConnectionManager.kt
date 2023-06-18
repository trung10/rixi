package com.ri.riix.ble

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import android.content.Context
import android.util.Log
import com.ri.riix.model.Data.UUID_MSG_CHARACTERISTIC
import com.ri.riix.model.Data.UUID_SERVICE_DEVICE
import com.ri.riix.utils.PacketSplitter
import com.ri.riix.utils.toUUID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import no.nordicsemi.android.ble.BleManager
import no.nordicsemi.android.ble.ktx.suspend

class BleConnectionManager(
    private val scope: CoroutineScope,
    context: Context,
    val device: BluetoothDevice
) : ConnectionInf, BleManager(context) {
    private val TAG = BleConnectionManager::class.java.simpleName
    var characteristic: BluetoothGattCharacteristic? = null


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

        /*setNotificationCallback(characteristic)
            // Merges packets until the entire text is present in the stream [PacketMerger.merge].
            .merge(PacketMerger())
            .asFlow()
            .onEach {

                val s = it.getStringValue(0)

                Log.e("Trung", "data: $s")

                it.isError?.let { isError -> _isError.emit(isError) }
                it.userJoined?.let { userJoined -> _userJoined.emit(userJoined) }
                it.question?.let { question -> _question.emit(question) }
                it.answerId?.let { answer -> _answer.emit(answer) }
                it.isGameOver?.let { isGameOver -> _isGameOver.emit(isGameOver) }
                it.result?.let { results -> _result.emit(results) }
            }
            .launchIn(scope)
        enableNotifications(characteristic).enqueue()*/

        setNotificationCallback(characteristic).with { _, data ->
            if (data.value != null) {
                val value = String(data.value!!, Charsets.UTF_8)
                Log.e(TAG, "Notification data: $value")
            }
        }
        enableNotifications(characteristic).fail { _, status ->
            Log.e(TAG, "enableNotifications: fail $status")
        }.enqueue()

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
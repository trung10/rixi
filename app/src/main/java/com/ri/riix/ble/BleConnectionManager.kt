package com.ri.riix.ble

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import android.content.Context
import com.ri.riix.model.Data.UUID_MSG_CHARACTERISTIC
import com.ri.riix.model.Data.UUID_SERVICE_DEVICE
import com.ri.riix.utils.PacketMerger
import com.ri.riix.utils.PacketSplitter
import com.ri.riix.utils.toUUID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import no.nordicsemi.android.ble.BleManager
import no.nordicsemi.android.ble.ktx.asResponseFlow
import no.nordicsemi.android.ble.ktx.suspend
import no.nordicsemi.android.ble.response.ReadResponse

class BleConnectionManager (
    val scope: CoroutineScope,
    context: Context,
    val device: BluetoothDevice
): ConnectionInf, BleManager(context) {

    var characteristic: BluetoothGattCharacteristic? = null


    override fun isRequiredServiceSupported(gatt: BluetoothGatt): Boolean {
        gatt.getService(UUID_SERVICE_DEVICE.toUUID())?.let { service ->
            characteristic = service.getCharacteristic(UUID_MSG_CHARACTERISTIC.toUUID())
        }
        return characteristic != null
    }

    override fun initialize() {
        requestMtu(512).enqueue() // request Mtu-512

      /*  setNotificationCallback(characteristic)
            // Merges packets until the entire text is present in the stream [PacketMerger.merge].
            .merge(PacketMerger())
            .asResponseFlow<String>()
            .onEach {
                it.isError?.let { isError -> _isError.emit(isError) }
                it.userJoined?.let { userJoined -> _userJoined.emit(userJoined) }
                it.question?.let { question -> _question.emit(question) }
                it.answerId?.let { answer -> _answer.emit(answer) }
                it.isGameOver?.let { isGameOver -> _isGameOver.emit(isGameOver) }
                it.result?.let { results -> _result.emit(results) }
            }
            .launchIn(scope)
        enableNotifications(characteristic).enqueue()*/
    }

    override fun onServicesInvalidated() {
        characteristic = null
    }

    suspend fun connect() {
        connect(device)
            .retry(4, 300)
            .useAutoConnect(false)
            .timeout(100_000)
            .suspend()
    }



    override suspend fun sendData(data: ByteArray) {
        writeCharacteristic(
            characteristic,
            data,
            BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
        )
            .split(PacketSplitter())
            .suspend()
    }

    override fun sendDataNoReturn(data: ByteArray) {
        TODO("Not yet implemented")
    }

    override fun scanDevice(): BluetoothDevice {
        TODO("Not yet implemented")
    }

    override fun pairDevice() {
        TODO("Not yet implemented")
    }

    fun release() {
        cancelQueue()
        disconnect().enqueue()
    }
}
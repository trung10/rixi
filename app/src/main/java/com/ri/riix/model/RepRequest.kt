package com.ri.riix.model

import android.bluetooth.BluetoothDevice
import android.util.Log
import no.nordicsemi.android.ble.data.Data
import no.nordicsemi.android.ble.response.ReadResponse
import okio.internal.commonToUtf8String

class RepRequest : ReadResponse() {
    var userJoined: String? = null
    var question: String? = null

    override fun onDataReceived(device: BluetoothDevice, data: Data) {
        val bytes = data.value!!
        val request = bytes.commonToUtf8String()
        Log.e("Trung", "aaaa: $request")

        when (request) {
           /* OpCodeProto.GAME_OVER -> { isGameOver = request.isGameOver }
            OpCodeProto.RESULT -> { result = request.results?.toResults() }
            OpCodeProto.ERROR -> { isError = Error(
                isEmptyName = request.isEmptyName,
                isDuplicateName = request.isDuplicateName,
            ) }*/
            else -> {}
        }
    }
}
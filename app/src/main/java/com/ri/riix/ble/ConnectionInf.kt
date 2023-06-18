package com.ri.riix.ble

import android.bluetooth.BluetoothDevice

interface ConnectionInf {
    suspend fun sendData(data: ByteArray)

    suspend fun sendDataNoReturn(data: ByteArray)

    fun readState(state : (String) -> Unit)

    //fun readRssi(): Int

    fun scanDevice(): BluetoothDevice

    fun pairDevice()
    fun release()
    fun startReadInterval()
}
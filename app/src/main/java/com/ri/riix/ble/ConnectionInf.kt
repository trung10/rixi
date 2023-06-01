package com.ri.riix.ble

import android.bluetooth.BluetoothDevice

interface ConnectionInf {
    suspend fun sendData(data: ByteArray)

    fun sendDataNoReturn(data: ByteArray)

    //fun readRssi(): Int

    fun scanDevice(): BluetoothDevice

    fun pairDevice()
}
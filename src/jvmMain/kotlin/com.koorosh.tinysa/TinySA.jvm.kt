package com.koorosh.tinysa

import jssc.*

class JvmTinySA : TinySA() {
    private var port = SerialPort("/dev/null")

    override fun connect() {
        port = SerialPort("/dev/cu.usbmodem4001")
        isConnected = port.openPort()
    }

    override fun disconnect() {
        isConnected = !port.closePort()
    }

    override fun sendCmd(cmd: String): ByteArray {
        port.writeBytes(cmd.encodeToByteArray())
        port.sendBreak(100)
        return port.readBytes()
    }
}

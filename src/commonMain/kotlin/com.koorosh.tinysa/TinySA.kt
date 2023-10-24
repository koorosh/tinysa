package com.koorosh.tinysa

// TinySA class implements commands available to send to TinySA device: https://tinysa.org/wiki/pmwiki.php?n=Main.USBInterface
abstract class TinySA {
    var isConnected: Boolean = false
    /*
    * data dumps the trace data
    * usage: data 0..2
    * 0=temp value, 1=stored trace, 2=measurement
    * */
    fun data(): ByteArray {
        if (!isConnected) {
            connect()
        }
        return sendCmd("data 2\r")
    }
    abstract fun connect()
    abstract fun disconnect()
    protected abstract fun sendCmd(cmd: String): ByteArray
}

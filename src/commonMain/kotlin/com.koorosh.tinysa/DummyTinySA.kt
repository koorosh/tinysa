package com.koorosh.tinysa

import kotlin.random.Random

// DummyTinySA implements dummy version of device that
// simulates correct connection to the device.
// The main purpose of this implementation is to test
// common logic that doesn't depend on the real source
// of data.
class DummyTinySA : TinySA() {
    override fun connect() {
        isConnected = true
    }

    override fun disconnect() {
        isConnected = false
    }

    override fun sendCmd(cmd: String): ByteArray {
        return Random.nextBytes(1000)
    }
}

package com.koorosh.tinysa

import kotlin.test.*

class TinySAJVMTest {
    @Test
    fun testConnect_WithoutDevice() {
        val tsa = JvmTinySA()
        assertFailsWith<jssc.SerialPortException> {
            tsa.connect()
        }
    }
}

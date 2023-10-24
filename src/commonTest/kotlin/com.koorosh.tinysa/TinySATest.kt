package com.koorosh.tinysa

import kotlin.test.Test
import kotlin.test.assertTrue

class TinySATest {
    @Test
    fun testDataCmd() {
        val tsa = DummyTinySA()
        val data = tsa.data()
        assertTrue(data.isNotEmpty())
    }
}

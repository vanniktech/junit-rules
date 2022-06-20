package com.vanniktech.junit4androidintegrationrules

import org.junit.Assert.assertEquals

@Suppress("Detekt.InstanceOfCheckForException") // https://github.com/arturbosch/detekt/pull/1424
inline fun <reified T> assertThrows(message: String, block: () -> Unit) {
  try {
    block()
    throw AssertionError("Expected ${T::class.java}")
  } catch (e: Throwable) {
    assertEquals(message, e.message)
    assertEquals("${e::class.java} <> ${T::class.java}", true, e is T)
  }
}

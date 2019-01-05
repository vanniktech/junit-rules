package com.vanniktech.junit4androidintegrationrules

import org.assertj.core.api.AbstractThrowableAssert
import org.assertj.core.api.Java6Assertions.assertThat

@Suppress("Detekt.InstanceOfCheckForException") // https://github.com/arturbosch/detekt/pull/1424
inline fun <reified T> assertThrows(block: () -> Unit): AbstractThrowableAssert<*, out Throwable> {
  try {
    block()
  } catch (e: Throwable) {
    if (e is T) {
      return assertThat(e)
    } else {
      throw e
    }
  }

  throw AssertionError("Expected ${T::class.simpleName}")
}

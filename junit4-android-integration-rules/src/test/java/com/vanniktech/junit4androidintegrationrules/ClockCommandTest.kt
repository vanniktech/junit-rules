package com.vanniktech.junit4androidintegrationrules

import com.vanniktech.junit4androidintegrationrules.ClockCommand.Companion.clock
import org.junit.Assert.assertEquals
import org.junit.Test

class ClockCommandTest {
  @Test fun name() {
    assertEquals("clock", clock().name)
  }

  @Test fun empty() {
    assertEquals(true, clock().asCommand().isEmpty())
  }

  @Test fun millis() {
    assertEquals(" -e millis 0", clock().millis(0).asCommand())
    assertEquals(" -e millis 1", clock().millis(1).asCommand())
    assertEquals(" -e millis 5", clock().millis(5).asCommand())
    assertEquals(" -e millis 100", clock().millis(100).asCommand())
  }

  @Test fun hhmm() {
    assertEquals(" -e hhmm 1100", clock().hhmm("1100").asCommand())
    assertEquals(" -e hhmm 2300", clock().hhmm("2300").asCommand())
  }
}

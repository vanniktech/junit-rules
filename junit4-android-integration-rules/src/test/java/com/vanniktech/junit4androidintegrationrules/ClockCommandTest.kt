package com.vanniktech.junit4androidintegrationrules

import com.vanniktech.junit4androidintegrationrules.ClockCommand.Companion.clock
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.Test

class ClockCommandTest {
  @Test fun name() {
    assertThat(clock().name).isEqualTo("clock")
  }

  @Test fun empty() {
    assertThat(clock().asCommand()).isEmpty()
  }

  @Test fun millis() {
    assertThat(clock().millis(0).asCommand()).isEqualTo(" -e millis 0")
    assertThat(clock().millis(1).asCommand()).isEqualTo(" -e millis 1")
    assertThat(clock().millis(5).asCommand()).isEqualTo(" -e millis 5")
    assertThat(clock().millis(100).asCommand()).isEqualTo(" -e millis 100")
  }

  @Test fun hhmm() {
    assertThat(clock().hhmm("1100").asCommand()).isEqualTo(" -e hhmm 1100")
    assertThat(clock().hhmm("2300").asCommand()).isEqualTo(" -e hhmm 2300")
  }
}

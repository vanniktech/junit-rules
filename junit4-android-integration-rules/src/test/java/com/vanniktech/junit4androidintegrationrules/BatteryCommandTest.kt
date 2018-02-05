package com.vanniktech.junit4androidintegrationrules

import com.vanniktech.junit4androidintegrationrules.BatteryCommand.Companion.battery
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.Test

class BatteryCommandTest {
  @Test fun name() {
    assertThat(battery().name).isEqualTo("battery")
  }

  @Test fun empty() {
    assertThat(battery().asCommand()).isEmpty()
  }

  @Test fun invalidLevel() {
    val builder = battery()

    assertThrows<IllegalArgumentException> {
      builder.level(-1)
    }.hasMessage("Battery level should be between 0 and 100")

    assertThrows<IllegalArgumentException> {
      builder.level(101)
    }.hasMessage("Battery level should be between 0 and 100")
  }

  @Test fun level() {
    assertThat(battery().level(0).asCommand()).isEqualTo(" -e level 0")
    assertThat(battery().level(1).asCommand()).isEqualTo(" -e level 1")
    assertThat(battery().level(5).asCommand()).isEqualTo(" -e level 5")
    assertThat(battery().level(100).asCommand()).isEqualTo(" -e level 100")
  }

  @Test fun plugged() {
    assertThat(battery().plugged(false).asCommand()).isEqualTo(" -e plugged false")
    assertThat(battery().plugged(true).asCommand()).isEqualTo(" -e plugged true")
  }

  @Test fun powersave() {
    assertThat(battery().powersave(false).asCommand()).isEqualTo(" -e powersave false")
    assertThat(battery().powersave(true).asCommand()).isEqualTo(" -e powersave true")
  }
}

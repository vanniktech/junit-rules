package com.vanniktech.junit4androidintegrationrules

import com.vanniktech.junit4androidintegrationrules.BatteryCommand.Companion.battery
import org.junit.Assert.assertEquals
import org.junit.Test

class BatteryCommandTest {
  @Test fun name() {
    assertEquals("battery", battery().name)
  }

  @Test fun empty() {
    assertEquals(true, battery().asCommand().isEmpty())
  }

  @Test fun invalidLevel() {
    val builder = battery()

    assertThrows<IllegalArgumentException>(message = "Battery level should be between 0 and 100") {
      builder.level(-1)
    }

    assertThrows<IllegalArgumentException>(message = "Battery level should be between 0 and 100") {
      builder.level(101)
    }
  }

  @Test fun level() {
    assertEquals(" -e level 0", battery().level(0).asCommand())
    assertEquals(" -e level 1", battery().level(1).asCommand())
    assertEquals(" -e level 5", battery().level(5).asCommand())
    assertEquals(" -e level 100", battery().level(100).asCommand())
  }

  @Test fun plugged() {
    assertEquals(" -e plugged false", battery().plugged(false).asCommand())
    assertEquals(" -e plugged true", battery().plugged(true).asCommand())
  }

  @Test fun powersave() {
    assertEquals(" -e powersave false", battery().powersave(false).asCommand())
    assertEquals(" -e powersave true", battery().powersave(true).asCommand())
  }
}

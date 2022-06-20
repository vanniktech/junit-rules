package com.vanniktech.junit4androidintegrationrules

import com.vanniktech.junit4androidintegrationrules.BarsCommand.BarMode
import com.vanniktech.junit4androidintegrationrules.BarsCommand.BarMode.BAR_MODE_OPAQUE
import com.vanniktech.junit4androidintegrationrules.BarsCommand.BarMode.BAR_MODE_SEMI_TRANSPARENT
import com.vanniktech.junit4androidintegrationrules.BarsCommand.BarMode.BAR_MODE_TRANSLUCENT
import com.vanniktech.junit4androidintegrationrules.BarsCommand.Companion.bars
import org.junit.Assert.assertEquals
import org.junit.Test

class BarsCommandTest {
  @Test fun name() {
    assertEquals("bars", bars().name)
  }

  @Test fun empty() {
    assertEquals(true, bars().asCommand().isEmpty())
  }

  @Test fun mode() {
    assertEquals(" -e mode opaque", bars().mode(BAR_MODE_OPAQUE).asCommand())
    assertEquals(" -e mode translucent", bars().mode(BAR_MODE_TRANSLUCENT).asCommand())
    assertEquals(" -e mode semi-transparent", bars().mode(BAR_MODE_SEMI_TRANSPARENT).asCommand())
  }

  @Test fun barModes() {
    assertEquals(listOf(BAR_MODE_OPAQUE, BAR_MODE_TRANSLUCENT, BAR_MODE_SEMI_TRANSPARENT), BarMode.values().toList())
  }
}

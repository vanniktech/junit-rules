package com.vanniktech.junit4androidintegrationrules

import com.vanniktech.junit4androidintegrationrules.BarsCommand.BarMode
import com.vanniktech.junit4androidintegrationrules.BarsCommand.BarMode.BAR_MODE_OPAQUE
import com.vanniktech.junit4androidintegrationrules.BarsCommand.BarMode.BAR_MODE_SEMI_TRANSPARENT
import com.vanniktech.junit4androidintegrationrules.BarsCommand.BarMode.BAR_MODE_TRANSLUCENT
import com.vanniktech.junit4androidintegrationrules.BarsCommand.Companion.bars
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.Test

class BarsCommandTest {
  @Test fun name() {
    assertThat(bars().name).isEqualTo("bars")
  }

  @Test fun empty() {
    assertThat(bars().asCommand()).isEmpty()
  }

  @Test fun mode() {
    assertThat(bars().mode(BAR_MODE_OPAQUE).asCommand()).isEqualTo(" -e mode opaque")
    assertThat(bars().mode(BAR_MODE_TRANSLUCENT).asCommand()).isEqualTo(" -e mode translucent")
    assertThat(bars().mode(BAR_MODE_SEMI_TRANSPARENT).asCommand()).isEqualTo(" -e mode semi-transparent")
  }

  @Test fun barModes() {
    assertThat(BarMode.values()).containsExactly(BAR_MODE_OPAQUE, BAR_MODE_TRANSLUCENT, BAR_MODE_SEMI_TRANSPARENT)
  }
}

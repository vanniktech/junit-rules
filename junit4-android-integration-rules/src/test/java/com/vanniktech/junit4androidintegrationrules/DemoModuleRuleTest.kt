package com.vanniktech.junit4androidintegrationrules

import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import org.junit.Assert.assertEquals
import org.junit.Test

@RequiresApi(VERSION_CODES.LOLLIPOP)
class DemoModuleRuleTest {
  @Test fun enterCommands() {
    val list = listOf(
      "settings put global sysui_demo_allowed 1",
      "am broadcast -a com.android.systemui.demo -e command exit",
      "am broadcast -a com.android.systemui.demo -e command enter",
      "am broadcast -a com.android.systemui.demo -e command notifications -e visible false",
      "am broadcast -a com.android.systemui.demo -e command status -e bluetooth hidden -e volume hidden -e speakerphone false -e location false -e mute false -e alarm false -e eri false -e sync false -e tty false",
      "am broadcast -a com.android.systemui.demo -e command network -e wifi show -e level 4 -e mobile false -e datatype hidden -e airplane false -e carriernetworkchange false",
      "am broadcast -a com.android.systemui.demo -e command battery -e level 100 -e plugged false -e powersave false",
      "am broadcast -a com.android.systemui.demo -e command clock -e hhmm 1100",
    )
    assertEquals(list, DemoModeRule().enterCommands())
  }

  @Test fun exitCommands() {
    val list = listOf(
      "am broadcast -a com.android.systemui.demo -e command exit",
    )
    assertEquals(list, DemoModeRule().exitCommands())
  }
}

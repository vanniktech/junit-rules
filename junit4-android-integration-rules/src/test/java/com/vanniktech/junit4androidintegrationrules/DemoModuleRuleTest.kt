package com.vanniktech.junit4androidintegrationrules

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.Test

class DemoModuleRuleTest {
  @Test fun enterCommands() {
    assertThat(DemoModeRule().enterCommands()).containsExactly(
        "settings put global sysui_demo_allowed 1",
        "am broadcast -a com.android.systemui.demo -e command exit",
        "am broadcast -a com.android.systemui.demo -e command enter",
        "am broadcast -a com.android.systemui.demo -e command notifications -e visible false",
        "am broadcast -a com.android.systemui.demo -e command status -e bluetooth hidden -e volume hidden -e speakerphone false -e location false -e mute false -e alarm false -e eri false -e sync false -e tty false",
        "am broadcast -a com.android.systemui.demo -e command network -e wifi false -e mobile show -e datatype hidden -e airplane false -e carriernetworkchange false",
        "am broadcast -a com.android.systemui.demo -e command battery -e level 100 -e plugged false -e powersave false",
        "am broadcast -a com.android.systemui.demo -e command clock -e hhmm 1100"
    )
  }

  @Test fun exitCommands() {
    assertThat(DemoModeRule().exitCommands()).containsExactly(
        "am broadcast -a com.android.systemui.demo -e command exit"
    )
  }
}

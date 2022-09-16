package com.vanniktech.junit4androidintegrationrules

import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import androidx.test.core.app.ActivityScenario
import com.facebook.testing.screenshot.Screenshot
import com.vanniktech.junit4androidintegrationrules.BatteryCommand.Companion.battery
import com.vanniktech.junit4androidintegrationrules.ClockCommand.Companion.clock
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.Companion.network
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileDataType.MOBILE_DATA_TYPE_E
import com.vanniktech.junit4androidintegrationrules.NotificationsCommand.Companion.notifications
import com.vanniktech.junit4androidintegrationrules.StatusCommand.BluetoothMode.BLUETOOTH_MODE_CONNECTED
import com.vanniktech.junit4androidintegrationrules.StatusCommand.Companion.status
import org.junit.Rule
import org.junit.Test

@RequiresApi(VERSION_CODES.LOLLIPOP)
class CustomDemoModeRuleTest {
  @get:Rule val demoModeRule = DemoModeRule(
    notifications().visible(false),
    network().wifi(true).mobileDataType(MOBILE_DATA_TYPE_E),
    battery().level(11).plugged(false).powersave(true),
    status().bluetooth(BLUETOOTH_MODE_CONNECTED).speakerphone(true),
    clock().hhmm("1800"),
  )
  @get:Rule val activityScenario = ActivityScenario.launch(NoOpActivity::class.java)

  @Test fun default() {
    // TODO figure out whether we can make this work. For some context - https://github.com/facebook/screenshot-tests-for-android/issues/148
    activityScenario.onActivity {
      Screenshot.snapActivity(it)
        .setGroup("Demo Mode")
        .setName("Custom")
        .record()
    }
  }
}

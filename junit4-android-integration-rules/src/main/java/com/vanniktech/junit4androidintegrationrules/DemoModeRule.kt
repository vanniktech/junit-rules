package com.vanniktech.junit4androidintegrationrules

import android.os.Build.VERSION_CODES.LOLLIPOP
import android.os.ParcelFileDescriptor
import android.os.ParcelFileDescriptor.AutoCloseInputStream
import androidx.annotation.RequiresApi
import androidx.test.platform.app.InstrumentationRegistry
import com.vanniktech.junit4androidintegrationrules.BatteryCommand.Companion.BATTERY_LEVEL_MAX
import com.vanniktech.junit4androidintegrationrules.BatteryCommand.Companion.battery
import com.vanniktech.junit4androidintegrationrules.ClockCommand.Companion.clock
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.Companion.network
import com.vanniktech.junit4androidintegrationrules.NetworkCommand.MobileDataType.MOBILE_DATA_TYPE_HIDDEN
import com.vanniktech.junit4androidintegrationrules.NotificationsCommand.Companion.notifications
import com.vanniktech.junit4androidintegrationrules.StatusCommand.BluetoothMode.BLUETOOTH_MODE_HIDDEN
import com.vanniktech.junit4androidintegrationrules.StatusCommand.Companion.status
import com.vanniktech.junit4androidintegrationrules.StatusCommand.VolumeMode.VOLUME_MODE_HIDDEN
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import java.io.BufferedReader
import java.io.InputStreamReader

private const val BROADCAST = "am broadcast -a com.android.systemui.demo -e command"

/**
 * This rule allows you to specify some of the UI demo commands and customize some part of the Status as well as the Navigation bar.
 * By default this will only show:
 * - Mobile data icon
 * - Battery as 100% and not charging
 * - Clock at 11 am
 * This can be customized by using the following commands.
 * [BarsCommand], [BatteryCommand], [ClockCommand], [NetworkCommand], [NotificationsCommand] and [StatusCommand].
 */
@RequiresApi(LOLLIPOP) class DemoModeRule(
  private vararg val commands: Command = listOf(
      notifications().visible(false),
      status().bluetooth(BLUETOOTH_MODE_HIDDEN).volume(VOLUME_MODE_HIDDEN).speakerphone(false).location(false).mute(false).alarm(false).eri(false).sync(false).tty(false),
      network().wifi(false).mobileDataType(MOBILE_DATA_TYPE_HIDDEN).airplane(false).carriernetworkchange(false),
      battery().level(BATTERY_LEVEL_MAX).plugged(false).powersave(false),
      clock().hhmm("1100")
  ).toTypedArray()
) : TestWatcher() {
  override fun starting(description: Description) = enterCommands().forEach { executeShellCommand(it) }

  override fun finished(description: Description) = exitCommands().forEach { executeShellCommand(it) }

  fun enterCommands() = listOf("settings put global sysui_demo_allowed 1")
      .plus(exitCommands())
      .plus("$BROADCAST enter")
      .plus(commands
        .map { it.name to it.asCommand() }
        .filter { (_, command) -> command.isNotEmpty() }
        .map { (name, command) -> "$BROADCAST $name$command" }
      )

  fun exitCommands() = listOf("$BROADCAST exit")

  private fun executeShellCommand(command: String) {
    val descriptor = InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand(command)
    waitForCompletion(descriptor)
  }

  private fun waitForCompletion(descriptor: ParcelFileDescriptor) {
    BufferedReader(InputStreamReader(AutoCloseInputStream(descriptor))).use {
      it.readText()
    }
  }
}

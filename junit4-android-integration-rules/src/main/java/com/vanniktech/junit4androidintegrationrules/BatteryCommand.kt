package com.vanniktech.junit4androidintegrationrules

/** Allows you to modify Battery as per https://android.googlesource.com/platform/frameworks/base/+/master/packages/SystemUI/docs/demo_mode.md */
class BatteryCommand private constructor() : Command("battery") {
  fun level(level: Int) = apply {
    require(level in BATTERY_LEVEL_MIN..BATTERY_LEVEL_MAX) { "Battery level should be between 0 and 100" }
    map["level"] = level
  }

  fun plugged(plugged: Boolean) = apply { map["plugged"] = plugged }

  fun powersave(powersave: Boolean) = apply { map["powersave"] = powersave }

  companion object {
    const val BATTERY_LEVEL_MIN = 0
    const val BATTERY_LEVEL_MAX = 100

    @JvmStatic fun battery() = BatteryCommand()
  }
}

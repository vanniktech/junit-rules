package com.vanniktech.junit4androidintegrationrules

/** Allows you to modify Clock as per https://android.googlesource.com/platform/frameworks/base/+/master/packages/SystemUI/docs/demo_mode.md */
class ClockCommand private constructor() : Command("clock") {
  fun millis(millis: Long) = apply { map["millis"] = millis }

  fun hhmm(hhmm: String) = apply { map["hhmm"] = hhmm }

  companion object {
    @JvmStatic fun clock() = ClockCommand()
  }
}

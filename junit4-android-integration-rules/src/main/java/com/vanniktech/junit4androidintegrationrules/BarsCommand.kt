package com.vanniktech.junit4androidintegrationrules

/** Allows you to modify Bars as per https://android.googlesource.com/platform/frameworks/base/+/master/packages/SystemUI/docs/demo_mode.md */
class BarsCommand private constructor() : Command("bars") {
  fun mode(mode: BarMode) = apply { map["mode"] = mode; }

  enum class BarMode(override val value: String) : EnumValue {
    BAR_MODE_OPAQUE("opaque"),
    BAR_MODE_TRANSLUCENT("translucent"),
    BAR_MODE_SEMI_TRANSPARENT("semi-transparent"),
  }

  companion object {
    @JvmStatic fun bars() = BarsCommand()
  }
}

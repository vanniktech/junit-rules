package com.vanniktech.junit4androidintegrationrules

/** Allows you to modify Network as per https://android.googlesource.com/platform/frameworks/base/+/master/packages/SystemUI/docs/demo_mode.md */
class NetworkCommand private constructor() : Command("network") {
  fun airplane(airplane: Boolean) = apply { map["airplane"] = airplane }

  fun fully(fully: Boolean) = apply { map["fully"] = fully }

  fun wifi(wifi: Boolean) = apply { map["wifi"] = wifi }

  fun wifiLevel(wifiLevel: WifiLevel) = apply {
    wifi(true)
    map["level"] = wifiLevel
  }

  fun mobile(mobile: Boolean) = apply { map["mobile"] = mobile }

  fun mobileDataType(mobileDataType: MobileDataType) = apply {
    mobile(true)
    map["datatype"] = mobileDataType
  }

  fun mobileLevel(mobileLevel: MobileLevel) = apply {
    mobile(true)
    map["level"] = mobileLevel
  }

  fun carriernetworkchange(carriernetworkchange: Boolean) = apply { map["carriernetworkchange"] = carriernetworkchange }

  fun sims(sims: Int) = apply {
    require(sims in SIMS_MIN_VALUE..SIMS_MAX_VALUE) { "Network sims should be between 1 and 8" }
    map["sims"] = sims
  }

  fun nosim(nosim: Boolean) = apply { map["nosim"] = nosim }

  enum class WifiLevel(override val value: String) : EnumValue {
    WIFI_LEVEL_NULL("null"),
    WIFI_LEVEL_0("0"),
    WIFI_LEVEL_1("1"),
    WIFI_LEVEL_2("2"),
    WIFI_LEVEL_3("3"),
    WIFI_LEVEL_4("4")
  }

  enum class MobileDataType(override val value: String) : EnumValue {
    MOBILE_DATA_TYPE_1X("1x"),
    MOBILE_DATA_TYPE_3G("3g"),
    MOBILE_DATA_TYPE_4G("4g"),
    MOBILE_DATA_TYPE_E("e"),
    MOBILE_DATA_TYPE_G("g"),
    MOBILE_DATA_TYPE_H("h"),
    MOBILE_DATA_TYPE_LTE("lte"),
    MOBILE_DATA_TYPE_ROAM("roam"),
    MOBILE_DATA_TYPE_HIDDEN("hidden")
  }

  enum class MobileLevel(override val value: String) : EnumValue {
    MOBILE_LEVEL_NULL("null"),
    MOBILE_LEVEL_0("0"),
    MOBILE_LEVEL_1("1"),
    MOBILE_LEVEL_2("2"),
    MOBILE_LEVEL_3("3"),
    MOBILE_LEVEL_4("4")
  }

  companion object {
    const val SIMS_MIN_VALUE = 1
    const val SIMS_MAX_VALUE = 8

    @JvmStatic fun network() = NetworkCommand()
  }
}

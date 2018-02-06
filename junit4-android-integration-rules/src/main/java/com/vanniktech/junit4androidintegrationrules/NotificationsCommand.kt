package com.vanniktech.junit4androidintegrationrules

/** Allows you to modify Notifications as per https://android.googlesource.com/platform/frameworks/base/+/master/packages/SystemUI/docs/demo_mode.md */
class NotificationsCommand private constructor() : Command("notifications") {
  fun visible(visible: Boolean) = apply { map["visible"] = visible }

  companion object {
    @JvmStatic fun notifications() = NotificationsCommand()
  }
}

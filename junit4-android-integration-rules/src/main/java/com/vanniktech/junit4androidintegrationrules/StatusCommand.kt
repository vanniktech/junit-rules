package com.vanniktech.junit4androidintegrationrules

/** Allows you to modify Status as per https://android.googlesource.com/platform/frameworks/base/+/master/packages/SystemUI/docs/demo_mode.md */
class StatusCommand private constructor() : Command("status") {
  fun volume(volume: VolumeMode) = apply { map["volume"] = volume }

  fun bluetooth(bluetooth: BluetoothMode) = apply { map["bluetooth"] = bluetooth }

  fun location(location: Boolean) = apply { map["location"] = location }

  fun alarm(alarm: Boolean) = apply { map["alarm"] = alarm }

  fun sync(sync: Boolean) = apply { map["sync"] = sync }

  fun tty(tty: Boolean) = apply { map["tty"] = tty }

  fun eri(eri: Boolean) = apply { map["eri"] = eri }

  fun mute(mute: Boolean) = apply { map["mute"] = mute }

  fun speakerphone(speakerphone: Boolean) = apply { map["speakerphone"] = speakerphone }

  enum class VolumeMode(override val value: String) : EnumValue {
    VOLUME_MODE_SILENT("silent"),
    VOLUME_MODE_VIBRATE("vibrate"),
    VOLUME_MODE_HIDDEN("hidden")
  }

  enum class BluetoothMode(override val value: String) : EnumValue {
    BLUETOOTH_MODE_CONNECTED("connected"),
    BLUETOOTH_MODE_DISCONNECTED("disconnected"),
    BLUETOOTH_MODE_HIDDEN("hidden")
  }

  companion object {
    @JvmStatic fun status() = StatusCommand()
  }
}

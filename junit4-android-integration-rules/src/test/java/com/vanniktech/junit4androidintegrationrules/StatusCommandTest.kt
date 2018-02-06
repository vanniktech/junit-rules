package com.vanniktech.junit4androidintegrationrules

import com.vanniktech.junit4androidintegrationrules.StatusCommand.BluetoothMode
import com.vanniktech.junit4androidintegrationrules.StatusCommand.BluetoothMode.BLUETOOTH_MODE_CONNECTED
import com.vanniktech.junit4androidintegrationrules.StatusCommand.BluetoothMode.BLUETOOTH_MODE_DISCONNECTED
import com.vanniktech.junit4androidintegrationrules.StatusCommand.BluetoothMode.BLUETOOTH_MODE_HIDDEN
import com.vanniktech.junit4androidintegrationrules.StatusCommand.Companion.status
import com.vanniktech.junit4androidintegrationrules.StatusCommand.VolumeMode
import com.vanniktech.junit4androidintegrationrules.StatusCommand.VolumeMode.VOLUME_MODE_HIDDEN
import com.vanniktech.junit4androidintegrationrules.StatusCommand.VolumeMode.VOLUME_MODE_SILENT
import com.vanniktech.junit4androidintegrationrules.StatusCommand.VolumeMode.VOLUME_MODE_VIBRATE
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.Test

class StatusCommandTest {
  @Test fun name() {
    assertThat(status().name).isEqualTo("status")
  }

  @Test fun empty() {
    assertThat(status().asCommand()).isEmpty()
  }

  @Test fun volume() {
    assertThat(status().volume(VOLUME_MODE_SILENT).asCommand()).isEqualTo(" -e volume silent")
    assertThat(status().volume(VOLUME_MODE_VIBRATE).asCommand()).isEqualTo(" -e volume vibrate")
    assertThat(status().volume(VOLUME_MODE_HIDDEN).asCommand()).isEqualTo(" -e volume hidden")
  }

  @Test fun bluetooth() {
    assertThat(status().bluetooth(BLUETOOTH_MODE_CONNECTED).asCommand()).isEqualTo(" -e bluetooth connected")
    assertThat(status().bluetooth(BLUETOOTH_MODE_DISCONNECTED).asCommand()).isEqualTo(" -e bluetooth disconnected")
    assertThat(status().bluetooth(BLUETOOTH_MODE_HIDDEN).asCommand()).isEqualTo(" -e bluetooth hidden")
  }

  @Test fun location() {
    assertThat(status().location(true).asCommand()).isEqualTo(" -e location show")
    assertThat(status().location(false).asCommand()).isEqualTo(" -e location false")
  }

  @Test fun alarm() {
    assertThat(status().alarm(true).asCommand()).isEqualTo(" -e alarm show")
    assertThat(status().alarm(false).asCommand()).isEqualTo(" -e alarm false")
  }

  @Test fun sync() {
    assertThat(status().sync(true).asCommand()).isEqualTo(" -e sync show")
    assertThat(status().sync(false).asCommand()).isEqualTo(" -e sync false")
  }

  @Test fun tty() {
    assertThat(status().tty(true).asCommand()).isEqualTo(" -e tty show")
    assertThat(status().tty(false).asCommand()).isEqualTo(" -e tty false")
  }

  @Test fun eri() {
    assertThat(status().eri(true).asCommand()).isEqualTo(" -e eri show")
    assertThat(status().eri(false).asCommand()).isEqualTo(" -e eri false")
  }

  @Test fun mute() {
    assertThat(status().mute(true).asCommand()).isEqualTo(" -e mute show")
    assertThat(status().mute(false).asCommand()).isEqualTo(" -e mute false")
  }

  @Test fun speakerphone() {
    assertThat(status().speakerphone(true).asCommand()).isEqualTo(" -e speakerphone show")
    assertThat(status().speakerphone(false).asCommand()).isEqualTo(" -e speakerphone false")
  }

  @Test fun volumeModes() {
    assertThat(VolumeMode.values()).containsExactly(VOLUME_MODE_SILENT, VOLUME_MODE_VIBRATE, VOLUME_MODE_HIDDEN)
  }

  @Test fun bluetoothModes() {
    assertThat(BluetoothMode.values()).containsExactly(BLUETOOTH_MODE_CONNECTED, BLUETOOTH_MODE_DISCONNECTED, BLUETOOTH_MODE_HIDDEN)
  }
}

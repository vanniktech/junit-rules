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
import org.junit.Assert.assertEquals
import org.junit.Test

class StatusCommandTest {
  @Test fun name() {
    assertEquals("status", status().name)
  }

  @Test fun empty() {
    assertEquals(true, status().asCommand().isEmpty())
  }

  @Test fun volume() {
    assertEquals(" -e volume silent", status().volume(VOLUME_MODE_SILENT).asCommand())
    assertEquals(" -e volume vibrate", status().volume(VOLUME_MODE_VIBRATE).asCommand())
    assertEquals(" -e volume hidden", status().volume(VOLUME_MODE_HIDDEN).asCommand())
  }

  @Test fun bluetooth() {
    assertEquals(" -e bluetooth connected", status().bluetooth(BLUETOOTH_MODE_CONNECTED).asCommand())
    assertEquals(" -e bluetooth disconnected", status().bluetooth(BLUETOOTH_MODE_DISCONNECTED).asCommand())
    assertEquals(" -e bluetooth hidden", status().bluetooth(BLUETOOTH_MODE_HIDDEN).asCommand())
  }

  @Test fun location() {
    assertEquals(" -e location show", status().location(true).asCommand())
    assertEquals(" -e location false", status().location(false).asCommand())
  }

  @Test fun alarm() {
    assertEquals(" -e alarm show", status().alarm(true).asCommand())
    assertEquals(" -e alarm false", status().alarm(false).asCommand())
  }

  @Test fun sync() {
    assertEquals(" -e sync show", status().sync(true).asCommand())
    assertEquals(" -e sync false", status().sync(false).asCommand())
  }

  @Test fun tty() {
    assertEquals(" -e tty show", status().tty(true).asCommand())
    assertEquals(" -e tty false", status().tty(false).asCommand())
  }

  @Test fun eri() {
    assertEquals(" -e eri show", status().eri(true).asCommand())
    assertEquals(" -e eri false", status().eri(false).asCommand())
  }

  @Test fun mute() {
    assertEquals(" -e mute show", status().mute(true).asCommand())
    assertEquals(" -e mute false", status().mute(false).asCommand())
  }

  @Test fun speakerphone() {
    assertEquals(" -e speakerphone show", status().speakerphone(true).asCommand())
    assertEquals(" -e speakerphone false", status().speakerphone(false).asCommand())
  }

  @Test fun volumeModes() {
    assertEquals(listOf(VOLUME_MODE_SILENT, VOLUME_MODE_VIBRATE, VOLUME_MODE_HIDDEN), VolumeMode.values().toList())
  }

  @Test fun bluetoothModes() {
    assertEquals(listOf(BLUETOOTH_MODE_CONNECTED, BLUETOOTH_MODE_DISCONNECTED, BLUETOOTH_MODE_HIDDEN), BluetoothMode.values().toList())
  }
}

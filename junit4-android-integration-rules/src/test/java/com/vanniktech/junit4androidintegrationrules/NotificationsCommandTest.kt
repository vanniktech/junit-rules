package com.vanniktech.junit4androidintegrationrules

import com.vanniktech.junit4androidintegrationrules.NotificationsCommand.Companion.notifications
import org.junit.Assert.assertEquals
import org.junit.Test

class NotificationsCommandTest {
  @Test fun name() {
    assertEquals("notifications", notifications().name)
  }

  @Test fun empty() {
    assertEquals(true, notifications().asCommand().isEmpty())
  }

  @Test fun visible() {
    assertEquals(" -e visible true", notifications().visible(true).asCommand())
    assertEquals(" -e visible false", notifications().visible(false).asCommand())
  }
}

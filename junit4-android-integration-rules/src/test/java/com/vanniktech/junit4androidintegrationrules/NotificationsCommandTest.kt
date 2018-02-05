package com.vanniktech.junit4androidintegrationrules

import com.vanniktech.junit4androidintegrationrules.NotificationsCommand.Companion.notifications
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.Test

class NotificationsCommandTest {
  @Test fun name() {
    assertThat(notifications().name).isEqualTo("notifications")
  }

  @Test fun empty() {
    assertThat(notifications().asCommand()).isEmpty()
  }

  @Test fun visible() {
    assertThat(notifications().visible(true).asCommand()).isEqualTo(" -e visible true")
    assertThat(notifications().visible(false).asCommand()).isEqualTo(" -e visible false")
  }
}

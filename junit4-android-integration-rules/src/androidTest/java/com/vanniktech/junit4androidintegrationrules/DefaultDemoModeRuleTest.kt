package com.vanniktech.junit4androidintegrationrules

import androidx.test.core.app.ActivityScenario
import com.facebook.testing.screenshot.Screenshot
import org.junit.Rule
import org.junit.Test

class DefaultDemoModeRuleTest {
  @get:Rule val demoModeRule = DemoModeRule()
  @get:Rule val activityScenario = ActivityScenario.launch(NoOpActivity::class.java)

  @Test fun default() {
    // TODO figure out whether we can make this work. For some context - https://github.com/facebook/screenshot-tests-for-android/issues/148
    activityScenario.onActivity {
      Screenshot.snapActivity(it)
        .setGroup("Demo Mode")
        .setName("Default")
        .record()
    }
  }
}

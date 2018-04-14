package com.vanniktech.junit4androidintegrationrules

import android.support.test.rule.ActivityTestRule
import com.facebook.testing.screenshot.Screenshot
import org.junit.Rule
import org.junit.Test

class DefaultDemoModeRuleTest {
  @get:Rule val demoModeRule = DemoModeRule()
  @get:Rule val activityRule = ActivityTestRule(NoOpActivity::class.java)

  @Test fun default() {
    // TODO figure out whether we can make this work. For some context - https://github.com/facebook/screenshot-tests-for-android/issues/148
    Screenshot.snapActivity(activityRule.activity)
        .setGroup("Demo Mode")
        .setName("Default")
        .record()
  }
}

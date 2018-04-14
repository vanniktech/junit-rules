package com.vanniktech.junit4androidintegrationrules

import android.support.test.rule.ActivityTestRule
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import java.util.Locale
import java.util.Locale.KOREAN

class DefaultLocaleRuleTest {
  @get:Rule val activityRule = ActivityTestRule(ForceLocaleRuleActivity::class.java)
  @get:Rule val forceLocalRule = DefaultLocaleRule()

  @Test fun firstShouldKeepDefault() {
    assertThat(activityRule.activity.textView.text).isEqualTo("en_US")
    assertThat(Locale.getDefault()).isEqualTo(default)

    Locale.setDefault(KOREAN) // Mutate the actual locale.
  }

  @Test(expected = UnsupportedOperationException::class) fun secondShouldNotBeAffected() {
    assertThat(activityRule.activity.textView.text).isEqualTo("en_US")
    assertThat(Locale.getDefault()).isNotEqualTo(KOREAN) // Mutation from previous test should not affect this one.

    throw UnsupportedOperationException() // Let it crash on purpose for the next method.
  }

  @Test fun thirdShouldNotBeAffectedEvenInCaseOfACrash() {
    assertThat(activityRule.activity.textView.text).isEqualTo("en_US")
    assertThat(Locale.getDefault()).isEqualTo(default)
  }

  companion object {
    val default = Locale.getDefault()
  }
}

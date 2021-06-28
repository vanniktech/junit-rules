package com.vanniktech.junit4androidintegrationrules

import android.annotation.SuppressLint
import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import androidx.test.rule.ActivityTestRule
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import java.util.Locale
import java.util.Locale.KOREAN

@RequiresApi(VERSION_CODES.LOLLIPOP)
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
    @SuppressLint("ConstantLocale") val default = Locale.getDefault()
  }
}

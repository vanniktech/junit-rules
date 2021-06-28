package com.vanniktech.junit4androidintegrationrules

import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import androidx.test.rule.ActivityTestRule
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runners.MethodSorters.NAME_ASCENDING
import java.util.Locale
import java.util.Locale.CHINESE
import java.util.Locale.KOREAN

@FixMethodOrder(NAME_ASCENDING) class DefaultLocaleRuleWithPreferenceTest {
  @get:Rule val activityRule = ActivityTestRule(ForceLocaleRuleActivity::class.java)
  @RequiresApi(VERSION_CODES.JELLY_BEAN_MR1)
  @get:Rule val forceLocalRule = DefaultLocaleRule(CHINESE)

  @Test fun firstShouldGetPreference() {
    assertThat(Locale.getDefault()).isEqualTo(CHINESE)
    assertThat(activityRule.activity.textView.text).isEqualTo("zh")

    Locale.setDefault(KOREAN) // Mutate the actual locale.
  }

  @Test(expected = UnsupportedOperationException::class) fun secondShouldNotBeAffected() {
    assertThat(Locale.getDefault()).isEqualTo(CHINESE) // Mutation from previous test should not affect this one.
    assertThat(activityRule.activity.textView.text).isEqualTo("zh")

    throw UnsupportedOperationException() // Let it crash on purpose for the next method.
  }

  @Test fun thirdShouldNotBeAffectedEvenInCaseOfACrash() {
    assertThat(activityRule.activity.textView.text).isEqualTo("zh")
    assertThat(Locale.getDefault()).isEqualTo(CHINESE)
  }
}

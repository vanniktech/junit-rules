package com.vanniktech.junit4androidintegrationrules

import android.annotation.SuppressLint
import androidx.test.core.app.ActivityScenario
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Rule
import org.junit.Test
import java.util.Locale
import java.util.Locale.KOREAN

class DefaultLocaleRuleTest {
  @get:Rule val activityScenario = ActivityScenario.launch(ForceLocaleRuleActivity::class.java)
  @get:Rule val forceLocalRule = DefaultLocaleRule()

  @Test fun firstShouldKeepDefault() {
    activityScenario.onActivity { assertEquals("en_US", it.textView.text) }
    assertEquals(default, Locale.getDefault())

    Locale.setDefault(KOREAN) // Mutate the actual locale.
  }

  @Test(expected = UnsupportedOperationException::class) fun secondShouldNotBeAffected() {
    activityScenario.onActivity { assertEquals("en_US", it.textView.text) }
    assertNotEquals(KOREAN, Locale.getDefault()) // Mutation from previous test should not affect this one.

    throw UnsupportedOperationException() // Let it crash on purpose for the next method.
  }

  @Test fun thirdShouldNotBeAffectedEvenInCaseOfACrash() {
    activityScenario.onActivity { assertEquals("en_US", it.textView.text) }
    assertEquals(default, Locale.getDefault())
  }

  companion object {
    @SuppressLint("ConstantLocale") val default = Locale.getDefault()
  }
}

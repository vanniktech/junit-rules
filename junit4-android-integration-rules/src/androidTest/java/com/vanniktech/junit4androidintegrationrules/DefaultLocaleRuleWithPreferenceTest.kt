package com.vanniktech.junit4androidintegrationrules

import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import androidx.test.core.app.ActivityScenario
import org.junit.Assert.assertEquals
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runners.MethodSorters.NAME_ASCENDING
import java.util.Locale
import java.util.Locale.CHINESE
import java.util.Locale.KOREAN

@FixMethodOrder(NAME_ASCENDING) class DefaultLocaleRuleWithPreferenceTest {
  @get:Rule val activityScenario = ActivityScenario.launch(ForceLocaleRuleActivity::class.java)
  @RequiresApi(VERSION_CODES.JELLY_BEAN_MR1)
  @get:Rule val forceLocalRule = DefaultLocaleRule(CHINESE)

  @Test fun firstShouldGetPreference() {
    assertEquals(CHINESE, Locale.getDefault())
    activityScenario.onActivity { assertEquals("zh", it.textView.text) }

    Locale.setDefault(KOREAN) // Mutate the actual locale.
  }

  @Test(expected = UnsupportedOperationException::class) fun secondShouldNotBeAffected() {
    assertEquals(CHINESE, Locale.getDefault()) // Mutation from previous test should not affect this one.
    activityScenario.onActivity { assertEquals("zh", it.textView.text) }

    throw UnsupportedOperationException() // Let it crash on purpose for the next method.
  }

  @Test fun thirdShouldNotBeAffectedEvenInCaseOfACrash() {
    activityScenario.onActivity { assertEquals("zh", it.textView.text) }
    assertEquals(CHINESE, Locale.getDefault())
  }
}

package com.vanniktech.junit4rules;

import java.util.Locale;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;

import static java.util.Locale.CHINESE;
import static java.util.Locale.KOREAN;
import static org.junit.Assert.assertEquals;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@FixMethodOrder(NAME_ASCENDING) public final class DefaultLocaleRuleWithPreferenceTest {
  @Rule public final DefaultLocaleRule defaultLocaleRule = new DefaultLocaleRule(CHINESE);

  @Test public void firstShouldGetPreference() {
    assertEquals(CHINESE, Locale.getDefault());

    Locale.setDefault(KOREAN); // Mutate the actual locale.
  }

  @Test(expected = UnsupportedOperationException.class) public void secondShouldNotBeAffected() {
    assertEquals(CHINESE, Locale.getDefault()); // Mutation from previous test should not affect this one.

    throw new UnsupportedOperationException(); // Let it crash on purpose for the next method.
  }

  @Test public void thirdShouldNotBeAffectedEvenInCaseOfACrash() {
    assertEquals(CHINESE, Locale.getDefault());
  }
}

package com.vanniktech.junit4rules;

import java.util.Locale;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;

import static java.util.Locale.KOREAN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@FixMethodOrder(NAME_ASCENDING) public final class DefaultLocaleRuleTest {
  private static final Locale DEFAULT;

  static {
    DEFAULT = Locale.getDefault();
  }

  @Rule public final DefaultLocaleRule defaultLocaleRule = new DefaultLocaleRule();

  @Test public void firstShouldKeepDefault() {
    assertEquals(DEFAULT, Locale.getDefault());

    Locale.setDefault(KOREAN); // Mutate the actual locale.
  }

  @Test(expected = UnsupportedOperationException.class) public void secondShouldNotBeAffected() {
    assertNotEquals(KOREAN, Locale.getDefault()); // Mutation from previous test should not affect this one.

    throw new UnsupportedOperationException(); // Let it crash on purpose for the next method.
  }

  @Test public void thirdShouldNotBeAffectedEvenInCaseOfACrash() {
    assertEquals(DEFAULT, Locale.getDefault());
  }
}

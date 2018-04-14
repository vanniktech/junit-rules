package com.vanniktech.junit4rules;

import java.util.Locale;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;

import static java.util.Locale.KOREAN;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@FixMethodOrder(NAME_ASCENDING) public final class DefaultLocaleRuleTest {
  private static final Locale DEFAULT;

  static {
    DEFAULT = Locale.getDefault();
  }

  @Rule public final DefaultLocaleRule defaultLocaleRule = new DefaultLocaleRule();

  @Test public void firstShouldKeepDefault() {
    assertThat(Locale.getDefault()).isEqualTo(DEFAULT);

    Locale.setDefault(KOREAN); // Mutate the actual locale.
  }

  @Test(expected = UnsupportedOperationException.class) public void secondShouldNotBeAffected() {
    assertThat(Locale.getDefault()).isNotEqualTo(KOREAN); // Mutation from previous test should not affect this one.

    throw new UnsupportedOperationException(); // Let it crash on purpose for the next method.
  }

  @Test public void thirdShouldNotBeAffectedEvenInCaseOfACrash() {
    assertThat(Locale.getDefault()).isEqualTo(DEFAULT);
  }
}

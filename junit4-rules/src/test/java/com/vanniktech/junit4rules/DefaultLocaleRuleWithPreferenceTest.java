package com.vanniktech.junit4rules;

import java.util.Locale;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;

import static java.util.Locale.CHINESE;
import static java.util.Locale.KOREAN;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@FixMethodOrder(NAME_ASCENDING) public final class DefaultLocaleRuleWithPreferenceTest {
  @Rule public final DefaultLocaleRule defaultLocaleRule = new DefaultLocaleRule(CHINESE);

  @Test public void firstShouldGetPreference() {
    assertThat(Locale.getDefault()).isEqualTo(CHINESE);

    Locale.setDefault(KOREAN); // Mutate the actual locale.
  }

  @Test(expected = UnsupportedOperationException.class) public void secondShouldNotBeAffected() {
    assertThat(Locale.getDefault()).isEqualTo(CHINESE); // Mutation from previous test should not affect this one.

    throw new UnsupportedOperationException(); // Let it crash on purpose for the next method.
  }

  @Test public void thirdShouldNotBeAffectedEvenInCaseOfACrash() {
    assertThat(Locale.getDefault()).isEqualTo(CHINESE);
  }
}

package com.vanniktech.junit4rules;

import java.util.TimeZone;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;

import static com.vanniktech.junit4rules.DefaultTimeZoneRuleWithPreferenceTest.TIME_ZONE_GMT_5;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@FixMethodOrder(NAME_ASCENDING) public final class DefaultTimeZoneRuleTest {
  private static final TimeZone DEFAULT;

  static {
    DEFAULT = TimeZone.getDefault();
  }

  @Rule public final DefaultTimeZoneRule defaultTimeZoneRule = new DefaultTimeZoneRule();

  @Test public void firstShouldKeepDefault() {
    assertThat(TimeZone.getDefault()).isEqualTo(DEFAULT);

    TimeZone.setDefault(TIME_ZONE_GMT_5); // Mutate the actual Time zone.
  }

  @Test(expected = RuntimeException.class) public void secondShouldNotBeAffected() {
    assertThat(TimeZone.getDefault()).isNotEqualTo(TIME_ZONE_GMT_5); // Mutation from previous test should not affect this one.

    throw new RuntimeException(); // Let it crash on purpose for the next method.
  }

  @Test public void thirdShouldNotBeAffectedEvenInCaseOfACrash() {
    assertThat(TimeZone.getDefault()).isEqualTo(DEFAULT);
  }
}

package com.vanniktech.junit4rules;

import java.util.TimeZone;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@FixMethodOrder(NAME_ASCENDING) public final class DefaultTimeZoneRuleWithPreferenceTest {
  static final TimeZone TIME_ZONE_GMT_8 = TimeZone.getTimeZone("GMT-08:00");
  static final TimeZone TIME_ZONE_GMT_5 = TimeZone.getTimeZone("GMT-05:00");

  @Rule public final DefaultTimeZoneRule defaultTimeZoneRule = new DefaultTimeZoneRule(TIME_ZONE_GMT_8);

  @Test public void firstShouldGetPreference() {
    assertEquals(TIME_ZONE_GMT_8, TimeZone.getDefault());

    TimeZone.setDefault(TIME_ZONE_GMT_5); // Mutate the actual Time zone.
  }

  @Test(expected = RuntimeException.class) public void secondShouldNotBeAffected() {
    assertEquals(TIME_ZONE_GMT_8, TimeZone.getDefault()); // Mutation from previous test should not affect this one.

    throw new RuntimeException(); // Let it crash on purpose for the next method.
  }

  @Test public void thirdShouldNotBeAffectedEvenInCaseOfACrash() {
    assertEquals(TIME_ZONE_GMT_8, TimeZone.getDefault());
  }
}

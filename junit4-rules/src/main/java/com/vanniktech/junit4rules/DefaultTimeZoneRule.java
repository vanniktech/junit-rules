package com.vanniktech.junit4rules;

import java.util.TimeZone;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public final class DefaultTimeZoneRule implements TestRule {
  final TimeZone preference;

  /** Creates the rule without any preference and will safely restore the default timezone prior to running the test, after the rest ran. */
  public DefaultTimeZoneRule() {
    preference = null;
  }

  /** Creates the rule with a preference and will safely restore the default timezone prior to running the test, after the rest ran. */
  public DefaultTimeZoneRule(final TimeZone preference) {
    this.preference = preference;
  }

  @Override public Statement apply(final Statement base, final Description description) {
    return new Statement() {
      @Override public void evaluate() throws Throwable {
        final TimeZone timeZone = TimeZone.getDefault();

        try {
          if (preference != null) {
            TimeZone.setDefault(preference);
          }

          base.evaluate();
        } finally {
          TimeZone.setDefault(timeZone);
        }
      }
    };
  }
}


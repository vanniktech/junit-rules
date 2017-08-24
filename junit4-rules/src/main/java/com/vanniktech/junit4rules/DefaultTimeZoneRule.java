package com.vanniktech.junit4rules;

import java.util.TimeZone;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/** JUnit rule for taking control over the Timezone. */
public final class DefaultTimeZoneRule implements TestRule {
  final TimeZone preference;

  /** Creates the rule and will safely restore the default timezone for each test. */
  public DefaultTimeZoneRule() {
    preference = null;
  }

  /** Creates the rule and will set the preferred timezone for each test. */
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


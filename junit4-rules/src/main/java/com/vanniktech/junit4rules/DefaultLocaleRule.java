package com.vanniktech.junit4rules;

import java.util.Locale;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public final class DefaultLocaleRule implements TestRule {
  final Locale preference;

  /** Creates the rule without any preference and will safely restore the default locale prior to running the test, after the rest ran. */
  public DefaultLocaleRule() {
    preference = null;
  }

  /** Creates the rule with a preference and will safely restore the default locale prior to running the test, after the rest ran. */
  public DefaultLocaleRule(final Locale preference) {
    this.preference = preference;
  }

  @Override public Statement apply(final Statement base, final Description description) {
    return new Statement() {
      @Override public void evaluate() throws Throwable {
        final Locale defaultLocale = Locale.getDefault();

        try {
          if (preference != null) {
            Locale.setDefault(preference);
          }

          base.evaluate();
        } finally {
          Locale.setDefault(defaultLocale);
        }
      }
    };
  }
}

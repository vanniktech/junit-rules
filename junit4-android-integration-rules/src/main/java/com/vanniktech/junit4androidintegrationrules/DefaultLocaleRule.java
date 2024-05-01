package com.vanniktech.junit4androidintegrationrules;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.test.platform.app.InstrumentationRegistry;
import java.util.Locale;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/** JUnit rule for taking control over the Locale. */
public final class DefaultLocaleRule implements TestRule {
  final Locale preference;

  /** Creates the rule and will restore the default locale for each test. */
  public DefaultLocaleRule() {
    preference = null;
  }

  /** Creates the rule and will set the preferred locale for each test. */
  public DefaultLocaleRule(final Locale preference) {
    this.preference = preference;
  }

  @Override public Statement apply(final Statement base, final Description description) {
    return new Statement() {
      @Override public void evaluate() throws Throwable {
        final Locale defaultLocale = Locale.getDefault();

        try {
          if (preference != null) {
            setLocale(preference);
          }

          base.evaluate();
        } finally {
          setLocale(defaultLocale);
        }
      }
    };
  }

  @SuppressLint("AppBundleLocaleChanges") void setLocale(final Locale locale) {
    final Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();

    Locale.setDefault(locale);

    final Resources resources = context.getResources();
    final Configuration config = resources.getConfiguration();
    config.setLocale(locale);
    resources.updateConfiguration(config, resources.getDisplayMetrics());
  }
}

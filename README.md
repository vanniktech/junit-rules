junit-rules
===========

[![Build Status](https://travis-ci.org/vanniktech/junit-rules.svg?branch=master)](https://travis-ci.org/vanniktech/junit-rules?branch=master)
[![Codecov](https://codecov.io/github/vanniktech/junit-rules/coverage.svg?branch=master)](https://codecov.io/github/vanniktech/junit-rules?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

A set of handy junit rules.

## JUnit 4

```groovy
testImplementation 'com.vanniktech:junit4-rules:0.2.0'
testImplementation 'com.vanniktech:junit4-rules:0.3.0-SNAPSHOT'
```

### DefaultLocaleRule

JUnit rule for taking control over the Locale.

```java
/** Creates the rule and will safely restore the default locale for each test. */
@Rule public final DefaultLocaleRule defaultLocaleRule = new DefaultLocaleRule();
```

```java
/** Creates the rule and will set the preferred locale for each test. */
@Rule public final DefaultLocaleRule defaultLocaleRule = new DefaultLocaleRule(US);
```

### DefaultTimeZoneRule

JUnit rule for taking control over the Timezone.

```java
/** Creates the rule and will safely restore the default timezone for each test. */
@Rule public final DefaultTimeZoneRule defaultTimeZoneRule = new DefaultTimeZoneRule();
```

```java
/** Creates the rule and will set the preferred timezone for each test. */
@Rule public final DefaultTimeZoneRule defaultTimeZoneRule = new DefaultTimeZoneRule(TimeZone.getTimeZone("GMT-08:00"));
```

For more information have a look at the [tests](junit4-rules/src/test/java/com/vanniktech/junit4rules/).

## JUnit 4 Android Integration

```groovy
androidTestImplementation 'com.vanniktech:junit4-android-integration-rules:0.2.0'
androidTestImplementation 'com.vanniktech:junit4-android-integration-rules:0.3.0-SNAPSHOT'
```

### DemoModeRule

JUnit rule for specifying some of the UI demo commands and customize some part of the Status as well as the Navigation bar. Thanks to [Hugo Visser](https://gist.github.com/hvisser/e716105f4e3cf2908ea463dbdb50679c) for this inspiration and sharing the initial piece.

```java
/** Creates the rule in default mode and shows you a clean status bar with half mobile data reception, 100% battery and an 11am clock. */
@Rule public final DemoModeRule demoModeRule = new DemoModeRule();
```

```java
/** Creates the rule and lets you specify all of your preferred certain options. Have a look at the documentation for more information. */
@Rule public final DemoModeRule demoModeRule = new DemoModeRule(
  notifications().visible(false),
  network().wifi(true).mobileDataType(MOBILE_DATA_TYPE_E),
  battery().level(11).plugged(false).powersave(true),
  status().bluetooth(BLUETOOTH_MODE_CONNECTED).speakerphone(true),
  clock().hhmm("1800")
)
```

For more information have a look at the [tests](junit4-android-integration-rules/src/androidTest/java/com/vanniktech/junit4androidintegrationrules/).

# License

Copyright (C) 2017 Vanniktech - Niklas Baudy

Licensed under the Apache License, Version 2.0

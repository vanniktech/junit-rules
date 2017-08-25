junit-rules
===========

[![Build Status](https://travis-ci.org/vanniktech/junit-rules.svg?branch=master)](https://travis-ci.org/vanniktech/junit-rules?branch=master)
[![Codecov](https://codecov.io/github/vanniktech/junit-rules/coverage.svg?branch=master)](https://codecov.io/github/vanniktech/junit-rules?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

A set of handy junit rules.

## JUnit 4

```groovy
compile 'com.vanniktech:junit4-rules:0.1.0'
compile 'com.vanniktech:junit4-rules:0.2.0-SNAPSHOT'
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

# License

Copyright (C) 2017 Vanniktech - Niklas Baudy

Licensed under the Apache License, Version 2.0
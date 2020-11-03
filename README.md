# Darjeeling for Android Testing

Darjeeling is a utility library for use with Android Testing. It's an
attempt at simplifying Android testing, by bypassing some of the features
of Espresso that often leads to flaky tests, as well as provide helpful
methods for evaluating application state.

Darjeeling forces compromise on some testing best practices such as
timed evaluations, but we consider the upside to enable testing with
asynchronous data loading far superior to a dogmatic approach to testing.

## Why use Darjeeling instead of Espresso?

First let's be clear: You do not have to choose either Darjeeling or
Espresso. You can easily use both together in the same testing setup,
allowing you to transition gradually over to Darjeeling.
In fact, the `DarjeelingActivityTest` is using Espresso to bootstrap
the tests.

Darjeeling offers a less abstract, less verbose DSL for writing UI
tests. We attempt to put more control in the hands of the test author,
compromising on some automated magic.

Darjeeling offers methods to verify the functionality of your UI. If you
need to verify that a button is actually visible to the user before it
is being pressed, you need to write a test for this yourself.

However, we will offer you a simple straight forward DSL for writing
this test.

We believe that UI testing is subject to flakiness and we want to
provide a tool that helps you write as stable and maintainable tests
possible in such an environment. That is done through simple tools and
leaving you, the test author, in control of the rest.

We are constantly expanding our library of utilities to achieve stable
and maintainable UI tests. Keep checking back for updates.

## Great, how do I include Darjeeling in my project?

First, you need to add the repository and dependency to your project build file.

```kotlin
repositories {
    maven(url = "http://repo.agens.no:8081/nexus/content/repositories/oss-releases")
}
```

Then add the Darjeeling dependency to the `androidTestImplementation`  
configuration:

```kotlin
dependencies {
    androidTestImplementation("no.agens.darjeeling:darjeeling-android-testing:$darjeeling_version")
}
```

Please see the [Github repository releases page](https://github.com/agensdev/darjeeling/releases)  
for the latest version.

## Code examples

Examples on how to use Darjeeling in your project is/will be available  
in the `app`-module of this repository. You can browse them here on  
Github or clone the repository and run them from Android Studio.

## User Guide

[A preliminary user guide is available here](docs/userguide.md).

## Developer documentation

This section contains documentation for developers contributing to the darjeeling-android-testing project itself.

### Publishing new releases

0. Update the version number in the `darjeeling-android-testing/build.gradle.kts` file and commit.
1. Tag the new version with a tag prefixed with `release_`, i.e. `release_0.70`
2. Push the changes and tags to the remote
3. Publish the new artifact using the Gradle command `./gradlew publish`

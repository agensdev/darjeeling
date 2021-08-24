# Darjeeling for Android Testing

Darjeeling is a utility library for use with Android Testing. It's an attempt at simplifying Android
testing, by making UI testing as low friction as possible.

Darjeeling builds on ActivityScenario and FragmentScenario from
`androidx.test:core` and `androidx.fragment:fragment-testing`, providing additional methods for more
streamlined, less boiler plate test authoring.

Darjeeling forces compromise on some testing best practices such as timed evaluations, but we
consider the upside to enable testing with asynchronous data loading far superior to a dogmatic
approach to testing.

## Why use Darjeeling instead of Espresso?

First let's be clear: You do not have to choose either Darjeeling or Espresso. Darjeeling is
designed to work both with and without Espresso. Darjeeling provides the constructs you need to
setup and run your tests, while you are free to use Espresso or any other library for UI
manipulation and verification.

Darjeeling offers a less abstract, less verbose DSL for writing UI tests. We attempt to put more
control in the hands of the test author, compromising on some automated magic.

Darjeeling offers methods to verify the functionality of your UI. If you need to verify that a
button is actually visible to the user before it is being pressed, you need to write a test for this
yourself - or use Espresso.

UI testing is subject to flakiness and we want to provide a tool that helps you write as stable and
maintainable tests possible in such an environment. That is done through simple tools and leaving
you, the test author, in control of the rest.

We are constantly expanding our library of utilities to achieve stable and maintainable UI tests.
Keep checking back for updates.

## Great, how do I include Darjeeling in my project?

Then add the Darjeeling dependency to the `androidTestImplementation`
configuration:

```kotlin
dependencies {
    androidTestImplementation("no.agens.darjeeling:darjeeling-android-testing:$darjeeling_version")
}
```

## Code examples

Examples on how to use Darjeeling in your project is/will be available in the `app`-module of this
repository. You can browse them here on Github or clone the repository and run them from Android
Studio.

## User Guide

[A preliminary user guide is available here](docs/userguide.md).

## Developer documentation

This section contains documentation for developers contributing to the darjeeling-android-testing
project itself.

### Publishing new releases

If you have not done so already, please configure necessary properties for publishing and signing
according
to [the vanniktech publishing plugin documentation](https://github.com/vanniktech/gradle-maven-publish-plugin)
.

0. Update the version number in the `darjeeling-android-testing/gradle.properties` file and commit.
1. Tag the new version with a tag prefixed with `release_`, i.e. `release_0.70`
2. Push the changes and tags to the remote
3. Publish the new artifact using the Gradle command `./gradlew publish --no-daemon --no-parallel`
4. Follow the [Sonatype documentation for releasing the published artifact](https://central.sonatype.org/publish/release/).

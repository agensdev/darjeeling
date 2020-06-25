# Darjeeling for Android Testing

Darjeeling is a utility library for use with Android Testing. It's an  
attempt at simplifying Android testing, by bypassing some of the features  
of Espresso that often leads to flaky tests, as well as provide helpful
methods for evaluating application state.

Darjeeling forces compromise on some testing best practices such as  
timed evaluations, but we consider the upside to enable testing with  
asynchronous data loading far superior to a dogmatic approach to testing.

## Great, how do I include Darjeeling in my project?

First, you need to add the repository and dependency to your project build file.

```kotlin
repositories {
    maven(url = "https://repo.agens.no:8081/nexus/content/groups/public")
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
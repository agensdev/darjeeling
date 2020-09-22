# 0.79
* Add new methods for obtaining CardView, ProgressBar and various layout view components.

# 0.78
* `view`-method is now generic and returns any supported view.

# 0.77
* Fix issue with `DarjeelingUtils.eventuallyActivityLaunched` not
working. Introduced new wrapper method `recordActivityLaunches` which
should be used as method body for tests checking for launched activities.
See `EventuallyActivityLaunchedTest` in app module for example.

# 0.76

* DarjeelingFragmentTest: Added new option to autolaunch fragments for
each test. This is the default behaviour. You can set this to `false`
to manually launch fragments using the `launchFragment()` method in
each test. Useful when you need to modify mocks and dependencies before
the fragment launches.
* DarjeelingFragmentTest: Add new method `onFragment` which lets you
pass in an action to perform on the launched fragment.

# 0.70

* First offical release of Darjeeling
* Contains helper classes for performing Activity and Fragment testing.
See `DarjeelingFragmentTest` and `DarjeelingActivityTest`.
* Helper methods for performing evaluations with timeout. Useful for
evaluating application state after asynchronous data loading. See `DarjeelingUtils`.


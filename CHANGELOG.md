# 0.91.1
* Fix bug in recently added strings-extension method with format args.

# 0.91
* Add string-extension methods for Activity and Fragment for getting strings with format arguments.

# 0.90
* New! We've simplified Activity and Fragment testing a great deal by introducing two new methods: `testActivity()` and `testFragment()`.
* DarjeelingActivityTest and DarjeelingFragmentTest has been deprecated in favor of this new testing approach.

# 0.82
* Bugfixes
* Now based on Espresso 3.3.0

# 0.81
* Add better support for coroutines with `eventually` methods.

# 0.80
* All eventually methods will now provide a better error message,
including the assertion error, when they time out.

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


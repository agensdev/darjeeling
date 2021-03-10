# Darjeeling User Guide

## Running fragment tests

Running tests on a fragment is done with the `testFragment` method:

```
testFragment(SampleFragment::class) {
    withFragment {
        // TODO perform operations on the fragment and assertions here
    }
}
```

You can find more documentation on testing fragments [here](https://developer.android.com/guide/fragments/test).

## Running activity tests

```
testActivity(MainActivity::class) { 
    onActivity { activity -> 
        // TODO perform operations on the activity and assertions here
    }
}
```

Further documentation on what you can do with the ActivityScenario can
be found [here](https://developer.android.com/reference/androidx/test/core/app/ActivityScenario).
[This blog post on testing with ActivityScenario](https://medium.com/google-developer-experts/stepping-into-activity-tests-with-activityscenarios-5db98d5311e6) can also be helpful for getting into activity testing.

## Utility methods for eventually asserting

Darjeeling provides utility methods for asserting various states that
can otherwise be tricky to assert in UI testing. Some of them are
described here. The rest can be found in the [DarjeelingUtils object](https://github.com/agensdev/darjeeling/blob/main/darjeeling-android-testing/src/main/java/no/agens/darjeeling/android/DarjeelingUtils.kt).

> Note that all `eventually*`-methods has to be called from the context
of `ActivityScenario` or `FragmentScenario`, not from within
`onActivity`, `onFragment` or `withFragment`.

### `eventually`

The `eventually` method enables you to make assertions that have a
timeout. In case of asynchorouns loading of data and UI operations,
this is very helpful when you want to assert various UI states which
you expect to happe, but you do not know exactly when.

### `eventuallyActivityLaunched` and `eventuallyFragmentLaunched`

These two methods enable you to eventually assert that an expected
`Activity` or `Fragment` was launched.

### `waitForRecyclerViewToHaveData`

`RecyclerViews` are usually populated asynchronously, and this method
allows you to wait while your `RecyclerView` is being populated.


### `checkDialogWithTextIsDisplayed`

This method allows you to check if an AlertDialog with a specific text
was displayed to the user.

## View lookup methods

Darjeeling provides both Activity and Fragment tests with useful methods for looking up and interacting with your view components.

These are available as extension methods for fragments and activities as well as `ActivityScenario` and `FragmentScenario`.

Example:
```
testFragment(MyFragment::class) {
    withFragment {
        textView(R.id.textField).text = "New text" 
        button(R.id.yourButton).performClick() 
    }
    
    val layout = constraintLayout(R.id.myConstraintLayout)
}

testActivity(MyActivity:class) {
    onActivity {
        button(R.id.myButton).performClick()
    }
    
    val textView = textView(R.id.textView)
    assertEquals("Expected text", textView.text.toString()) 
    
}
```

All functions that manipulates a view has to be called from within the
context of `onActivity`, `onFragment` or `withFragment` to be executed
n the correct thread.
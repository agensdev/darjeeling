# Darjeeling User Guide

## Utility methods for eventually asserting

Darjeeling provides utility methods for asserting various states that  
can otherwise be tricky to assert in UI testing. Some of them are  
described here. The rest can be found in the [DarjeelingUtils object](https://github.com/agensdev/darjeeling/blob/main/darjeeling-android-testing/src/main/java/no/agens/darjeeling/android/DarjeelingUtils.kt).

### `eventually`

The `eventually` method enables you to make assertions that have a
timeout. In case of asynchorouns loading of data and UI operations,
this is very helpful when you want to assert various UI states which
you expect to happe, but you do not know exactly when.

### `eventuallyActivityLaunched` and `eventuallyFragmentLaunched`

These two methods enable you to eventually assert that an expected
`Activity` or `Fragment` was launched.

### `waitForRecyclerViewToHaveData`

`RecyclerViews` are usually populated asynchronously, and this method allows you to wait while your `RecyclerView` is being populated.


### `checkDialogWithTextIsDisplayed`

This method allows you to check if an AlertDialog with a specific text
was displayed to the user.

## View lookup methods

Darjeeling provides both Activity and Fragment tests with useful methods for looking up and interacting with your view components.

These are available as methods in your tests from the `DarjeelingBase` base class:

```
button(R.id.yourButton).performClick()
textView(R.id.textField).text = "New text"
imageView(R.id.textField).background = ...
```

Please note than when performing interractions with UI components you
will have to run these on the main thread. The `runBlocking(Dispatchers.Main)`
from Kotlin Coroutines is a clean and efficient way to do this.
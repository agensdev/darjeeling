package no.agens.darjeeling.android

import android.app.Activity
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.GeneralLocation
import androidx.test.espresso.action.GeneralSwipeAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Swipe
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import no.agens.darjeeling.android.ext.stackTraceAsString
import org.junit.Assert.fail
import java.lang.System.currentTimeMillis
import kotlin.reflect.KClass

object DarjeelingUtils {

    private const val DEFAULT_TIMEOUT = 2000L

    fun eventually(timeoutMs: Long = DEFAULT_TIMEOUT, assertion: () -> Unit) {
        val start = currentTimeMillis()
        var lastError: Error? = null
        while (currentTimeMillis() < start + timeoutMs) {
            try {
                assertion()
                return
            } catch (ex: Error) {
                lastError = ex
                Thread.sleep(100)
            }
        }

        fail("Waited for $timeoutMs ms.\n\uD83D\uDCA5 Assertion error: ${lastError?.message}. Trace: ${lastError?.stackTraceAsString()}")

    }

    @Deprecated("Use eventually from now on.")
    fun eventuallyAssertThat(timeoutMs: Long = DEFAULT_TIMEOUT, assertion: () -> Unit) {
        eventually(timeoutMs, assertion)
    }

    @Deprecated("Use eventually from now on.")
    fun eventuallyAsserted(timeoutMs: Long = DEFAULT_TIMEOUT, assertionFunction: () -> Unit) {
        eventually(timeoutMs, assertionFunction)
    }

    fun <T : Activity> eventuallyActivityLaunched(
        timeoutMs: Long = DEFAULT_TIMEOUT,
        activity: KClass<T>
    ) {

        eventuallyAsserted(timeoutMs = timeoutMs) {
            intended(hasComponent(activity.java.name))
        }
    }

    fun recordActivityLaunches(block: () -> Unit) {
        Intents.init()
        try {
            block()
        } finally {
            Intents.release()
        }
    }

    fun eventuallyFragmentLaunched(
        timeoutMs: Long = DEFAULT_TIMEOUT,
        fragmentManager: FragmentManager, tag: String
    ) {

        val fragmentLaunchedTest = {
            fragmentManager.findFragmentByTag(tag) ?: throw IllegalStateException(
                "Fragment not yet launched"
            )
        }

        val start = currentTimeMillis()
        while (currentTimeMillis() < start + timeoutMs) {
            try {
                fragmentLaunchedTest()
                return
            } catch (ex: IllegalStateException) {
                Thread.sleep(100)
            }
        }

        println("Waited for $timeoutMs ms.")
        fragmentLaunchedTest()
    }

    fun waitFor(timeoutMs: Long = DEFAULT_TIMEOUT, assertion: () -> Unit) {
        val start = currentTimeMillis()
        while (currentTimeMillis() < start + timeoutMs) {
            try {
                assertion()
                return
            } catch (ex: Error) {
                Thread.sleep(100)
            }
        }

        println("Waited for $timeoutMs ms.")
        assertion()
    }


    fun waitForRecyclerViewToHaveData(
        recyclerView: RecyclerView?,
        timeoutMs: Long = DEFAULT_TIMEOUT
    ) {

        val start = currentTimeMillis()
        while (currentTimeMillis() < start + timeoutMs && recyclerView?.childCount == 0) {
            Thread.sleep(100)
        }

        if (currentTimeMillis() >= start + timeoutMs && recyclerView?.childCount == 0) {
            fail("Timed out waiting for RecyclerView to receive data. Waited for $timeoutMs ms.")
        }
    }

    fun checkDialogWithTextIsDisplayed(@StringRes titleRes: Int): ViewInteraction {

        return Espresso.onView(ViewMatchers.withText(titleRes))
            .inRoot(RootMatchers.isDialog()).check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
    }

    fun slideRecyclerItemLeft(@IdRes recyclerViewId: Int, position: Int): ViewInteraction {
        return Espresso.onView(ViewMatchers.withId(recyclerViewId)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                GeneralSwipeAction(
                    Swipe.FAST, GeneralLocation.CENTER_RIGHT,
                    GeneralLocation.CENTER,
                    Press.FINGER
                )
            )
        )
    }
}
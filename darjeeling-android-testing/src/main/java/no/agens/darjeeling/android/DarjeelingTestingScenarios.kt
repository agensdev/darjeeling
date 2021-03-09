package no.agens.darjeeling.android

import android.app.Activity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.intent.Intents
import kotlin.reflect.KClass

fun <T : Activity> testActivity(activityClass: KClass<T>, perform: (ActivityScenario<T>) -> Unit) {

    Intents.init()
    try {
        ActivityScenario.launch(activityClass.java).use { activityScenario ->
            perform(activityScenario)
        }
    } finally {
        Intents.release()
    }
}

inline fun <reified F : Fragment> testFragment(fragmentClass: KClass<F>, args: Bundle = bundleOf(),
    perform: (FragmentScenario<F>) -> Unit) {

    Intents.init()
    try {
        val scenario: FragmentScenario<F> = launchFragmentInContainer(args)
        perform(scenario)
    } finally {
        Intents.release()
    }
}
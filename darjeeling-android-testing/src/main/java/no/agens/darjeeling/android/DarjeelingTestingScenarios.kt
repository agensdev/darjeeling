package no.agens.darjeeling.android

import android.app.Activity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.FragmentScenario
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

fun <F : Fragment> testFragment(fragmentClass: KClass<F>, args: Bundle = bundleOf(),
    perform: (FragmentScenario<F>) -> Unit) {

    Intents.init()
    try {
        val scenario: FragmentScenario<F> = FragmentScenario.launchInContainer(fragmentClass.java, args)
        perform(scenario)
    } finally {
        Intents.release()
    }
}
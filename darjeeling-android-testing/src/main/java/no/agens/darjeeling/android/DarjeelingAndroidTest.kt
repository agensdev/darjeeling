package no.agens.darjeeling.android

import android.app.Activity
import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import kotlin.reflect.KClass


abstract class DarjeelingAndroidTest<T : Activity>(
    activityClass: KClass<T>) : DarjeelingViewExtensions() {

    override val activity: Activity
        get() = activityRule.activity

    @get:Rule
    var activityRule: ActivityTestRule<T> = object : ActivityTestRule<T>(activityClass.java) {
        override fun getActivityIntent(): Intent {
            val activityIntent = Intent(InstrumentationRegistry.getInstrumentation().targetContext,
                activityClass.java)
            addExtras(activityIntent)
            return activityIntent
        }
    }

    abstract fun addExtras(intent: Intent)


}
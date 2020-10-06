package no.agens.darjeeling.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.intent.Intents
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import kotlin.reflect.KClass


abstract class DarjeelingActivityTest<T : AppCompatActivity>(
    activityClass: KClass<T>) : DarjeelingBase() {

    override val activity: T
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

    @Before
    fun before() {
        Intents.init()
    }

    @After
    fun after() {
        Intents.release()
    }

    abstract fun addExtras(intent: Intent)


}
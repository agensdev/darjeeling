package no.agens.darjeeling

import android.content.Intent
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.runBlocking
import no.agens.darjeeling.android.DarjeelingActivityTest
import no.agens.darjeeling.android.DarjeelingUtils.eventuallyActivityLaunched
import org.junit.Test

class EventuallyActivityLaunchedTest : DarjeelingActivityTest<MainActivity>(MainActivity::class) {
    override fun addExtras(intent: Intent) {
    }

    @Test
    fun launchingActivitiesCanBeCheckedWitheventuallyActivityLaunched() {
        runBlocking(Main) {
            button(R.id.buttonLaunchAnotherActivity).performClick()
        }

        eventuallyActivityLaunched(activity = AnotherActivity::class)
    }
}
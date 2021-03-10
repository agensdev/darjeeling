package no.agens.darjeeling

import no.agens.darjeeling.android.DarjeelingUtils.eventuallyActivityLaunched
import no.agens.darjeeling.android.ext.button
import no.agens.darjeeling.android.testActivity
import org.junit.Test

class EventuallyActivityLaunchedTest {

    @Test
    fun launchingActivitiesCanBeCheckedWitheventuallyActivityLaunched() {

        testActivity(MainActivity::class) {

            onActivity {
                button(R.id.buttonLaunchAnotherActivity).performClick()
            }

            eventuallyActivityLaunched(activity = AnotherActivity::class)
        }
    }
}

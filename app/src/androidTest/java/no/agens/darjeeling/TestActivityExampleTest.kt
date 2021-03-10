package no.agens.darjeeling

import no.agens.darjeeling.android.DarjeelingUtils.eventuallyActivityLaunched
import no.agens.darjeeling.android.ext.button
import no.agens.darjeeling.android.ext.textView
import no.agens.darjeeling.android.testActivity
import org.junit.Assert.assertEquals
import org.junit.Test

class TestActivityExampleTest {

    @Test
    fun demonstrateUseOfTestActivity() {

        testActivity(MainActivity::class) {
            onActivity {
                button(R.id.buttonLaunchAnotherActivity).performClick()
            }
            eventuallyActivityLaunched(activity = AnotherActivity::class)
        }
    }

    @Test
    fun demonstrateUseOfTestActivity2() {

        testActivity(MainActivity::class) {
            onActivity {
                button(R.id.buttonHello).performClick()
                assertEquals("Activity says hello.", textView(R.id.textDemo).text.toString())
            }
        }
    }
}
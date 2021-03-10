package no.agens.darjeeling

import androidx.core.os.bundleOf
import no.agens.darjeeling.android.ext.button
import no.agens.darjeeling.android.testFragment
import org.junit.Assert.assertEquals
import org.junit.Test

class TestFragmentExampleTest {

    @Test
    fun demonstrateTestFragment() {

        testFragment(SampleFragment::class) { scenario ->
            scenario.onFragment { fragment ->

                fragment.button(R.id.buttonForTesting).performClick()
                assertEquals("Changed text", fragment.button(R.id.buttonForTesting).text.toString())
            }
        }
    }

    @Test
    fun demonstrateTestFragmentWithArgs() {

        val expectedInitialText = "Hi there!"
        testFragment(SampleFragment::class, bundleOf("initial_button_text" to expectedInitialText)) { scenario ->

            scenario.onFragment { fragment ->
                assertEquals(expectedInitialText, fragment.button(R.id.buttonForTesting).text.toString())
            }
        }
    }
}
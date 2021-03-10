package no.agens.darjeeling

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.withFragment
import no.agens.darjeeling.android.ext.button
import no.agens.darjeeling.android.testFragment
import org.junit.Assert.assertEquals
import org.junit.Test

class TestFragmentExampleTest {

    @Test
    fun demonstrateTestFragment() {

        testFragment(SampleFragment::class) {
            withFragment {
                button(R.id.buttonForTesting).performClick()
                assertEquals("Changed text", button(R.id.buttonForTesting).text.toString())
            }
        }
    }

    @Test
    fun demonstrateTestFragmentWithArgs() {

        val expectedInitialText = "Hi there!"
        testFragment(SampleFragment::class, bundleOf("initial_button_text" to expectedInitialText)) {
            withFragment {
                assertEquals(expectedInitialText, button(R.id.buttonForTesting).text.toString())
            }
        }
    }
}
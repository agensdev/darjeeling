package no.agens.darjeeling

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import no.agens.darjeeling.android.DarjeelingFragmentTest
import no.agens.darjeeling.android.DarjeelingUtils.eventuallyAssertThat
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import org.koin.test.KoinTest

class SampleFragmentWithoutAutolaunchTest : DarjeelingFragmentTest<SampleFragment>(autoLaunchFragments = false),
    KoinTest {
    override fun createFragmentScenario(): FragmentScenario<SampleFragment> {
        return launchFragmentInContainer<SampleFragment>()
    }

    private var mockDependency: MainActivity.MyDependency = mockk {
        every {
            doSomething()
        } just Runs

        every {
            returnsTrue()
        } returns true
    }

    fun setupKoin() {
        // unloadKoinModules() // You should unload your app modules here to make sure they are rebuilt prior to running the test.
        loadKoinModules(module {
            factory(override = true) {
                mockDependency
            }
        })
    }

    @Test
    fun textFieldIsSetToTrue() {
        // Test setup with launchFragment for explicitly launching at the right time
        setupKoin()
        launchFragment()

        eventuallyAssertThat {
            assertThat(textView(R.id.textBoolean).text.toString()).isEqualTo("true")
        }
    }

    @Test
    fun textFieldIsSetToFalse() {

        // Redefine mock
        mockDependency = mockk {
            every {
                doSomething()
            } just Runs

            every {
                returnsTrue()
            } returns false
        }

        setupKoin()
        launchFragment()

        eventuallyAssertThat {
            assertThat(textView(R.id.textBoolean).text.toString()).isEqualTo("false")
        }
    }
}
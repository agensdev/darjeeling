package no.agens.darjeeling

import androidx.fragment.app.testing.withFragment
import io.mockk.*
import no.agens.darjeeling.android.ext.button
import no.agens.darjeeling.android.testFragment
import org.junit.Assert
import org.junit.Test
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import org.koin.test.KoinTest

class SampleFragmentWithKoinTest : KoinTest {

    private val mockedDependency = mockk<MainActivity.MyDependency> {
        every {
            doSomething()
        } just Runs

        every {
            returnsTrue()
        } returns true
    }

    init {
        loadKoinModules(module {
            factory(override = true) { mockedDependency }
        })
    }

    @Test
    fun verifyDependencyCalledOnButtonClick() {

        testFragment(SampleFragment::class) {
            withFragment {
                val buttonforTesting = button(R.id.buttonForTesting)
                buttonforTesting.performClick()
                Assert.assertEquals("Changed text", buttonforTesting.text.toString())
                verify(exactly = 1) {
                    mockedDependency.doSomething()
                }
            }
        }
    }

}
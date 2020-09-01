package no.agens.darjeeling

import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.*
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.runBlocking
import no.agens.darjeeling.android.DarjeelingFragmentTest
import org.junit.AfterClass
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.dsl.module

class SampleFragmentWithKoinTest : DarjeelingFragmentTest<SampleFragment>() {

    private val mockedDependency = mockk<MainActivity.MyDependency> {
        every {
            doSomething()
        } just Runs

        every {
            returnsTrue()
        } returns true
    }

    override fun createFragmentScenario(): FragmentScenario<SampleFragment> {
        return launchFragmentInContainer(Bundle(), R.style.AppTheme)
    }

    init {
        startKoin {
            modules(module {
                factory<MainActivity.MyDependency>(override = true) { mockedDependency }
            })
        }
    }

    @Test
    fun verifyDependencyCalledOnButtonClick() {
        runBlocking(Main) {
            button(R.id.buttonForTesting).performClick()
            Assert.assertEquals("Changed text", button(R.id.buttonForTesting).text.toString())
            verify(exactly = 1) {
                mockedDependency.doSomething()
            }
        }
    }

    companion object {

        @JvmStatic
        @AfterClass
        fun stopKoin() {
            stopKoin()
        }
    }
}
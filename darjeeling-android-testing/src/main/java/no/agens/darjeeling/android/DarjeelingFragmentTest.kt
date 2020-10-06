package no.agens.darjeeling.android

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.testing.FragmentScenario
import androidx.test.espresso.intent.Intents
import org.junit.After
import org.junit.Before

abstract class DarjeelingFragmentTest<F : Fragment>(
    private val autoLaunchFragments: Boolean = true
) : DarjeelingBase() {

    private lateinit var underlyingActivity: FragmentActivity
    private lateinit var scenario: FragmentScenario<F>

    override val activity: FragmentActivity
        get() = underlyingActivity

    @Before
    open fun before() {
        Intents.init()
        if (autoLaunchFragments) {
            launchFragment()
        }
    }

    @After
    open fun after() {
        Intents.release()
    }

    abstract fun createFragmentScenario(): FragmentScenario<F>

    fun launchFragment() {
        scenario = createFragmentScenario()
        scenario.onFragment {

            this.underlyingActivity = it.activity!!
        }
    }

    fun onFragment(action: (F) -> Unit) {
        scenario.onFragment(action)
    }


}
package no.agens.darjeeling.android

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.testing.FragmentScenario
import org.junit.Before

abstract class DarjeelingFragmentTest<F : Fragment>(private val autoLaunchFragments: Boolean = true) :
    DarjeelingBase() {

    private lateinit var underlyingActivity: FragmentActivity
    private lateinit var scenario: FragmentScenario<F>

    override val activity: FragmentActivity
        get() = underlyingActivity

    @Before
    open fun setup() {
        if (autoLaunchFragments) {
            launchFragment()
        }
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
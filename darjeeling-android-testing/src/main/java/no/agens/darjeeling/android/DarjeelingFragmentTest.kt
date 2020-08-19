package no.agens.darjeeling.android

import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.testing.FragmentScenario
import org.junit.Before

abstract class DarjeelingFragmentTest<F : Fragment> : DarjeelingBase() {

    private lateinit var underlyingActivity: FragmentActivity
    lateinit var scenario: FragmentScenario<F>

    override val activity: ComponentActivity
        get() = underlyingActivity

    @Before
    open fun setup() {
        scenario = createFragmentScenario()
        scenario.onFragment {

            this.underlyingActivity = it.activity!!
        }
    }

    abstract fun createFragmentScenario(): FragmentScenario<F>


}
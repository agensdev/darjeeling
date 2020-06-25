package no.agens.darjeeling

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import no.agens.darjeeling.android.DarjeelingFragmentTest

class SampleFragmentTest : DarjeelingFragmentTest<SampleFragment>() {
    override fun createFragmentScenario(): androidx.fragment.app.testing.FragmentScenario<SampleFragment> {
        return launchFragmentInContainer(Bundle(), R.style.AppTheme)
    }

}
package no.agens.darjeeling

import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import no.agens.darjeeling.android.DarjeelingFragmentTest

class SampleFragmentWithKoinTest : DarjeelingFragmentTest<SampleFragment>() {
    override fun createFragmentScenario(): FragmentScenario<SampleFragment> {
        return launchFragmentInContainer(Bundle(), R.style.AppTheme)
    }

    init {
        // Example of loadKoinModules and override
    }
}
package no.agens.darjeeling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sample.*
import org.koin.android.ext.android.inject

class SampleFragment : Fragment() {

    private val dependency: MainActivity.MyDependency by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonForTesting.setOnClickListener {
            buttonForTesting.text = "Changed text"
            dependency.doSomething()
        }

        textBoolean.text = dependency.returnsTrue().toString()
    }
}
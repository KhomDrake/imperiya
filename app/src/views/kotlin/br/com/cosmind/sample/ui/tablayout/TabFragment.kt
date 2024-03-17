package br.com.cosmind.sample.ui.tablayout

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import br.com.arch.toolkit.delegate.extraProvider
import br.com.arch.toolkit.delegate.viewProvider
import br.com.cosmind.sample.R

class TabFragment: Fragment(R.layout.tab_fragment) {

    private val title: AppCompatTextView by viewProvider(R.id.title)

    private val titleValue by extraProvider<String>("title", "Not Found")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title.text = titleValue
    }

    companion object {

        fun instance(title: String) = TabFragment()
            .apply {
                arguments = bundleOf(
                    "title" to title
                )
            }

    }

}
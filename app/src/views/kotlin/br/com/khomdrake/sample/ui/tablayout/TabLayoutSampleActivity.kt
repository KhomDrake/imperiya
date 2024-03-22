package br.com.khomdrake.sample.ui.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import br.com.arch.toolkit.delegate.viewProvider
import br.com.khomdrake.sample.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutSampleActivity: AppCompatActivity(R.layout.activity_tabs_sample) {

    private val toolbar: Toolbar by viewProvider(R.id.toolbar)
    private val tabs: TabLayout by viewProvider(R.id.tabs)
    private val layout: ViewPager2 by viewProvider(R.id.layout)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        val texts = listOf(
            "About",
            "Recommendation",
            "Cast",
            "Reviews",
            "Seasons"
        )

        val adapter = TabAdapter(texts, this)
        layout.adapter = adapter
        TabLayoutMediator(tabs, layout) { tab, position ->
            tab.text = texts[position]
        }.attach()
    }

}
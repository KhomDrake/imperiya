package br.com.khomdrake.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.arch.toolkit.delegate.viewProvider
import br.com.khomdrake.sample.ui.ColorsActivity
import br.com.khomdrake.sample.ui.ColorsDynamicActivity
import br.com.khomdrake.sample.ui.bottomsheet.BottomSheetSampleActivity
import br.com.khomdrake.sample.ui.button.ButtonSampleActivity
import br.com.khomdrake.sample.ui.chips.ChipsSampleActivity
import br.com.khomdrake.sample.ui.warnings.WarningSampleActivity
import br.com.khomdrake.sample.ui.search.SearchSampleActivity
import br.com.khomdrake.sample.ui.stateview.StateViewSampleActivity
import br.com.khomdrake.sample.ui.tablayout.TabLayoutSampleActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val toolbar: Toolbar by viewProvider(R.id.toolbar)
    private val components: RecyclerView by viewProvider(R.id.components)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        components.layoutManager = LinearLayoutManager(this)
        components.adapter = ComponentsAdapter(listOf(
            Component(
                "Colors", ColorsActivity::class
            ),
            Component(
                "Dynamic Colors", ColorsDynamicActivity::class
            ),
            Component(
                "Search Views", SearchSampleActivity::class
            ),
            Component(
                "Error State", WarningSampleActivity::class
            ),
            Component(
                "Buttons", ButtonSampleActivity::class
            ),
            Component(
                "Chips", ChipsSampleActivity::class
            ),
            Component(
                "Bottom Sheet", BottomSheetSampleActivity::class
            ),
            Component(
                "Tab Layout", TabLayoutSampleActivity::class
            ),
            Component(
                "State View", StateViewSampleActivity::class
            )
        ))

    }

}
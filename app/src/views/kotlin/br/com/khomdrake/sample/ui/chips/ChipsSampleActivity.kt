package br.com.khomdrake.sample.ui.chips

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import br.com.arch.toolkit.delegate.viewProvider
import br.com.khomdrake.sample.R

class ChipsSampleActivity : AppCompatActivity(R.layout.activity_chip_sample) {

    private val toolbar: Toolbar by viewProvider(R.id.toolbar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

}
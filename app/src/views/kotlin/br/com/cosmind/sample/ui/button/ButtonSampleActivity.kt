package br.com.cosmind.sample.ui.button

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import br.com.arch.toolkit.delegate.viewProvider
import br.com.cosmind.sample.R

class ButtonSampleActivity : AppCompatActivity(R.layout.activity_button_sample) {

    private val toolbar: Toolbar by viewProvider(R.id.toolbar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

}
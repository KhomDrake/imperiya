package br.com.cosmind.sample.ui.warnings.smallwarning

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import br.com.arch.toolkit.delegate.viewProvider
import br.com.cosmind.imperiya.ui.warning.SmallWarningView
import br.com.cosmind.sample.R

class SmallWarningSampleActivity : AppCompatActivity(R.layout.activity_small_warning_sample) {

    private val toolbar: Toolbar by viewProvider(R.id.toolbar)
    private val smallWarning: SmallWarningView by viewProvider(R.id.small_warning_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        smallWarning.setOnClickLink {
            Toast.makeText(this, "Try again clicked", Toast.LENGTH_SHORT).show()
        }
    }

}
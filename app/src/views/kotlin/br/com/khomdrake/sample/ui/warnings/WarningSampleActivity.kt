package br.com.khomdrake.sample.ui.warnings

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import br.com.arch.toolkit.delegate.viewProvider
import br.com.khomdrake.sample.R
import br.com.khomdrake.sample.ui.warnings.smallwarning.SmallWarningSampleActivity
import br.com.khomdrake.sample.ui.warnings.warning.BigWarningSampleActivity

class WarningSampleActivity : AppCompatActivity(R.layout.activity_warning_sample) {

    private val toolbar: Toolbar by viewProvider(R.id.toolbar)
    private val smallErrorButton: AppCompatButton by viewProvider(R.id.small_error)
    private val bigErrorButton: AppCompatButton by viewProvider(R.id.big_error)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        smallErrorButton.setOnClickListener {
            startActivity(
                Intent(this, SmallWarningSampleActivity::class.java)
            )
        }
        bigErrorButton.setOnClickListener {
            startActivity(
                Intent(this, BigWarningSampleActivity::class.java)
            )
        }
    }

}
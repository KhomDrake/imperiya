package br.com.khomdrake.sample.ui.warnings.warning.examples

import androidx.appcompat.app.AppCompatActivity
import br.com.arch.toolkit.delegate.viewProvider
import br.com.khomdrake.sample.R
import br.com.khomdrake.imperiya.ui.warning.WarningView

abstract class DefaultWarningSampleActivity : AppCompatActivity(R.layout.activity_warning_default_sample) {

    protected val warningView: WarningView by viewProvider(R.id.warning_view)

}
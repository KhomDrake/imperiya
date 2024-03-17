package br.com.cosmind.sample.ui.warnings.warning.examples

import android.os.Bundle
import android.widget.Toast
import br.com.cosmind.imperiya.R

class WarningErrorSampleActivity : DefaultWarningSampleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        warningView.apply {
            setTitle("Error Title")
            setBody("Error Body")
            setButtonText("Try again button text")
            setStatusIcon(R.drawable.ic_close_error)
            setOnTryAgain {
                Toast.makeText(this@WarningErrorSampleActivity, "Clicked", Toast.LENGTH_SHORT).show()
            }
            setCloseIcon {
                finish()
            }
        }
    }

}
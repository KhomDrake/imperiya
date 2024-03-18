package br.com.khomdrake.sample.ui.warnings.warning.examples

import android.os.Bundle
import android.widget.Toast
import br.com.khomdrake.imperiya.R

class WarningSuccessSampleActivity : DefaultWarningSampleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        warningView.apply {
            setTitle("Succes Title")
            setBody("Success Body")
            setButtonText(null)
            setStatusIcon(R.drawable.ic_success)
            setOnTryAgain {
                Toast.makeText(this@WarningSuccessSampleActivity, "Clicked", Toast.LENGTH_SHORT).show()
            }
            setCloseIcon {
                finish()
            }
        }
    }

}
package br.com.khomdrake.sample.ui.warningview

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.khomdrake.imperiya.ui.theme.ImperiyaTheme
import br.com.khomdrake.sample.ButtonList
import br.com.khomdrake.sample.Component

class WarningsComponentSampleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImperiyaTheme {
                val activities = listOf(
                    Component(
                        "Small Warning",
                        SmallWarningComponentActivity::class
                    ),
                    Component(
                        "Warning",
                        WarningListComponentActivity::class
                    ),
                )

                ButtonList(
                    "Warning Components",
                    activities,
                    onClick = {
                        startActivity(
                            Intent(
                                this,
                                it.activity.java
                            ).apply {
                                putExtras(it.bundle)
                            }
                        )
                    }
                ) {
                    finish()
                }
            }
        }
    }

}
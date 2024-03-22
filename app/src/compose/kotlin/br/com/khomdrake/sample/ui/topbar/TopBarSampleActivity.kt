package br.com.khomdrake.sample.ui.topbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.khomdrake.imperiya.ui.theme.ImperiyaTheme

class TopBarSampleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImperiyaTheme {
            }
        }
    }

}
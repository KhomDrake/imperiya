package br.com.cosmind.sample.ui.topbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.cosmind.imperiya.ui.theme.ImperiyaTheme

class TopBarSampleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImperiyaTheme {
            }
        }
    }

}
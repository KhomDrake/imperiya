package br.com.cosmind.sample.ui.texts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.cosmind.imperiya.ui.theme.ImperiyaTheme

class TextSampleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImperiyaTheme {
            }
        }
    }

}
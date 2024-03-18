package br.com.cosmind.sample.ui.button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.cosmind.imperiya.ui.components.DefaultTopBar
import br.com.cosmind.imperiya.ui.components.ErrorButton
import br.com.cosmind.imperiya.ui.components.NeutralButton
import br.com.cosmind.imperiya.ui.components.NormalButton
import br.com.cosmind.imperiya.ui.preview.BackgroundPreview
import br.com.cosmind.imperiya.ui.theme.ImperiyaTheme

class ButtonSampleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImperiyaTheme {
                Scaffold(
                    topBar = {
                        DefaultTopBar(title = "Button Sample") {
                            finish()
                        }
                    }
                ) {
                    ContentButtonSample(paddingValues = it)
                }
            }
        }
    }

}

@Composable
fun ContentButtonSample(
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = paddingValues.calculateTopPadding() + 16.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            )
    ) {
        NormalButton(
            name = "Normal Button",
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
        )
        NeutralButton(
            name = "Neutral Button",
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )
        ErrorButton(
            name = "Error Button",
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )
    }
}

@PreviewLightDark
@Composable
fun ContentButtonSamplePreview() {
    ImperiyaTheme {
        BackgroundPreview {
            ContentButtonSample(
                paddingValues = PaddingValues()
            )
        }
    }
}
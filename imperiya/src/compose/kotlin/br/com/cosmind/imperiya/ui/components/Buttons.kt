package br.com.cosmind.imperiya.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.cosmind.imperiya.ui.preview.BackgroundPreview
import br.com.cosmind.imperiya.ui.theme.ImperiyaTheme
import br.com.cosmind.imperiya.ui.theme.ImperiyaTypography

@Composable
fun ErrorButton(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    NormalButton(
        name = name,
        onClick = onClick,
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.error,
        textColor = MaterialTheme.colorScheme.onError
    )
}

@Composable
fun NormalButton(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.tertiary,
    textColor: Color = MaterialTheme.colorScheme.onTertiary,
    capsEnabled: Boolean = true
) {
    Button(
        modifier = modifier
            .defaultMinSize(minHeight = 48.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor
        )
    ) {
        Text(
            text = if(capsEnabled) name.uppercase() else name,
            style = ImperiyaTypography.SubTitleBoldStyle,
            color = textColor
        )
    }
}

@Composable
fun NeutralButton(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    NormalButton(
        name = name,
        onClick = onClick,
        modifier = modifier
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(24.dp)
            ),
        containerColor = Color.Transparent,
        textColor = MaterialTheme.colorScheme.onBackground
    )
}

@PreviewLightDark
@Composable
fun NeutralButtonPreview() {
    ImperiyaTheme {
        BackgroundPreview {
            NeutralButton(
                name = "Normal Button",
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@PreviewLightDark
@PreviewFontScale
@Composable
fun NormalButtonPreview() {
    ImperiyaTheme {
        BackgroundPreview {
            NormalButton(
                name = "Normal Button",
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@PreviewLightDark
@Composable
fun ErrorButtonPreview() {
    ImperiyaTheme {
        BackgroundPreview {
            ErrorButton(
                name = "Error Button",
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

package br.com.cosmind.imperiya.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import br.com.cosmind.imperiya.ui.theme.ImperiyaTheme
import br.com.cosmind.imperiya.ui.theme.ImperiyaTypography

class TextPreviewData(
    val textStyle: TextStyle,
    val name: String,
)

class TextProvider : PreviewParameterProvider<TextPreviewData> {

    override val values: Sequence<TextPreviewData>
        get() = listOf(
            TextPreviewData(
                ImperiyaTypography.ParagraphStyle,
                "ParagraphStyle"
            ),
            TextPreviewData(
                ImperiyaTypography.ParagraphBoldStyle,
                "ParagraphBoldStyle"
            ),
            TextPreviewData(
                ImperiyaTypography.ParagraphBigStyle,
                "ParagraphBigStyle"
            ),
            TextPreviewData(
                ImperiyaTypography.LinkStyle,
                "LinkStyle"
            ),
            TextPreviewData(
                ImperiyaTypography.ChipStyle,
                "ChipStyle"
            ),
            TextPreviewData(
                ImperiyaTypography.SubTitleStyle,
                "SubTitleStyle"
            ),
            TextPreviewData(
                ImperiyaTypography.SubTitleSmallStyle,
                "SubTitleSmallStyle"
            ),
            TextPreviewData(
                ImperiyaTypography.SubTitleBigStyle,
                "SubTitleBigStyle"
            ),
            TextPreviewData(
                ImperiyaTypography.SubTitleBoldStyle,
                "SubTitleBoldStyle"
            ),
            TextPreviewData(
                ImperiyaTypography.TitleStyle,
                "TitleStyle"
            ),
            TextPreviewData(
                ImperiyaTypography.TitleBigStyle,
                "TitleBigStyle"
            ),
        ).asSequence()

}

@PreviewLightDark
@Composable
fun TextsPreview(
    @PreviewParameter(TextProvider::class) data: TextPreviewData
) {
    ImperiyaTheme {
        Text(
            text = data.name,
            style = data.textStyle,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

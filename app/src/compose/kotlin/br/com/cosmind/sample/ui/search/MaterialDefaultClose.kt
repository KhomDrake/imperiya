package br.com.cosmind.sample.ui.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.cosmind.imperiya.ui.components.SearchCloseComponent
import br.com.cosmind.imperiya.ui.theme.ImperiyaTypography

@Composable
fun MaterialDefaultClose() {
    var language by remember {
        mutableStateOf("")
    }

    var active by remember { mutableStateOf(false) }

    SearchCloseComponent(
        query = language,
        hint = "Write a language",
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        onSearch = {
            active = false
        },
        onQueryChange = {
            language = it
        },
        onActiveChange = {
           active = it
        },
        active = active,
        content = {
            LazyColumn(
                content = {
                    items(3) {
                        Text(
                            text = it.toString(),
                            style = ImperiyaTypography.ParagraphBoldStyle,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )
                    }
                }
            )
        },
        onClickClose = {
            language += "ended"
        }
    )
}
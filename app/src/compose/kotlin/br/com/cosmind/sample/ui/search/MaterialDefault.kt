package br.com.cosmind.sample.ui.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import br.com.cosmind.imperiya.ui.components.SearchComponent
import br.com.cosmind.imperiya.ui.theme.ImperiyaTypography

@Composable
fun MaterialDefault() {
    var language by remember {
        mutableStateOf("")
    }

    var isActive by remember {
        mutableStateOf(false)
    }

    Column {
        SearchComponent(
            query = language,
            hint = "Write a language",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            onSearch = {
                isActive = false
            },
            onActiveChange = {
                isActive = it
            },
            active = isActive,
            onQueryChange = {
                language = it
            },
            content = {
                LazyColumn(
                    content = {
                        items(3) {
                            Text(
                                text = it.toString(),
                                style = ImperiyaTypography.ParagraphBoldStyle,
                                color = MaterialTheme.colorScheme.onSecondaryContainer,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                                    .clickable {
                                        isActive = false
                                    }
                            )
                        }
                    }
                )
            }
        )

        if(!isActive)
            Text(text = "Text", style = ImperiyaTypography.SubTitleBoldStyle, color = MaterialTheme.colorScheme.onBackground)
    }




}
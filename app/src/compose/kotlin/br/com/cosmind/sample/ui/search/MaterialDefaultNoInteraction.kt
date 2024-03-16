package br.com.cosmind.sample.ui.search

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import br.com.cosmind.imperiya.ui.components.DefaultTopBar
import br.com.cosmind.imperiya.ui.components.SearchComponent

@Composable
fun MaterialDefaultNoInteraction() {
    var show by remember { mutableStateOf(false) }

    Column {
        SearchComponent(
            hint = "Write a language",
            onClick = {
                show = !show
            },
            enable = false
        )

        if(show) {
            DefaultTopBar(title = "Showing toolbar") {

            }
        }
    }

}
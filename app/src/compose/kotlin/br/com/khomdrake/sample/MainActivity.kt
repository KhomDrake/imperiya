package br.com.khomdrake.sample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import br.com.khomdrake.imperiya.ui.components.DefaultTopBar
import br.com.khomdrake.imperiya.ui.components.NormalButton
import br.com.khomdrake.imperiya.ui.theme.ImperiyaTheme
import br.com.khomdrake.imperiya.ui.theme.ImperiyaTypography
import br.com.khomdrake.sample.ui.ColorsActivity
import br.com.khomdrake.sample.ui.DynamicColorsActivity
import br.com.khomdrake.sample.ui.bottomsheet.BottomSheetActivity
import br.com.khomdrake.sample.ui.button.ButtonSampleActivity
import br.com.khomdrake.sample.ui.chips.ChipsSampleActivity
import br.com.khomdrake.sample.ui.search.SearchSampleActivity
import br.com.khomdrake.sample.ui.state.StateComponentSampleActivity
import br.com.khomdrake.sample.ui.tab.TabSampleActivity
import br.com.khomdrake.sample.ui.texts.TextSampleActivity
import br.com.khomdrake.sample.ui.topbar.TopBarSampleActivity
import br.com.khomdrake.sample.ui.warningview.WarningsComponentSampleActivity
import kotlin.reflect.KClass

class Component(
    val title: String,
    val activity: KClass<*>,
    val bundle: Bundle = bundleOf()
)

abstract class SampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImperiyaTheme {
                Content()
            }
        }
    }

    @Composable
    abstract fun Content()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activities = listOf(
            Component(
                "Colors",
                ColorsActivity::class
            ),
            Component(
                "Dynamic Colors Dark",
                DynamicColorsActivity::class,
                bundleOf(
                    "DARK_MODE" to true
                )
            ),
            Component(
                "Dynamic Colors Light",
                DynamicColorsActivity::class,
                bundleOf(
                    "DARK_MODE" to false
                )
            ),
            Component(
                "Chips",
                ChipsSampleActivity::class
            ),
            Component(
                "Search",
                SearchSampleActivity::class
            ),
            Component(
                "Buttons",
                ButtonSampleActivity::class
            ),
            Component(
                "State Component",
                StateComponentSampleActivity::class
            ),
            Component(
                "Texts",
                TextSampleActivity::class
            ),
            Component(
                "TopBar",
                TopBarSampleActivity::class
            ),
            Component(
                "Warning View",
                WarningsComponentSampleActivity::class
            ),
            Component(
                "Tab Sample",
                TabSampleActivity::class
            ),
            Component(
                "Bottom Sheet",
                BottomSheetActivity::class
            ),
        )

        setContent {
            ImperiyaTheme {
                ButtonList(
                    stringResource(id = R.string.app_name),
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

@Preview
@Composable
fun MainPreview() {
    ImperiyaTheme {
        ButtonList(
            "Sample Views",
            listOf(),
            {

            },
            {

            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonList(
    title: String,
    activities: List<Component>,
    onClick: (Component) -> Unit,
    onBackButton: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            DefaultTopBar(title = title, onBackButton = onBackButton)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = it.calculateTopPadding())
        ) {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item(
                    key = "Title"
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "Components:",
                        style = ImperiyaTypography.TitleStyle,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                items(items = activities) { component ->
                    ComponentItem(
                        component = component,
                        onClick = onClick,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    }


}

@Composable
fun ComponentItem(
    component: Component,
    onClick: (Component) -> Unit,
    modifier: Modifier = Modifier
) {
    NormalButton(
        modifier = modifier,
        onClick = {
            onClick.invoke(component)
        },
        name = component.title
    )
}
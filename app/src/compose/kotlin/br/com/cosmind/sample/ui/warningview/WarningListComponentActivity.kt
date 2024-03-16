package br.com.cosmind.sample.ui.warningview

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import br.com.cosmind.imperiya.ui.theme.ImperiyaTheme
import br.com.cosmind.sample.ButtonList
import br.com.cosmind.sample.Component
import br.com.cosmind.imperiya.R
import br.com.cosmind.imperiya.ui.components.DefaultTopBar
import br.com.cosmind.imperiya.ui.components.WarningView
import kotlinx.parcelize.Parcelize

class WarningListComponentActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImperiyaTheme {
                val activities = listOf<Component>(
                    Component(
                        "Warning Error Sample",
                        WarningItemComponentActivity::class,
                        bundleOf(
                            "ITEM" to WarningViewItem(
                                "Warning Error Sample",
                                "Error Title",
                                "Error Body",
                                linkAction = "Try again button text"
                            )
                        )
                    ),
                    Component(
                        "Warning Success Sample",
                        WarningItemComponentActivity::class,
                        bundleOf(
                            "ITEM" to WarningViewItem(
                                "Warning Success Sample",
                                "Success Title",
                                "Success Body",
                                warningIcon = R.drawable.ic_success,
                                warningColorIcon = R.color.color_imperiya_success
                            )
                        )
                    ),
                    Component(
                        "Warning Without Close Icon Sample",
                        WarningItemComponentActivity::class,
                        bundleOf(
                            "ITEM" to WarningViewItem(
                                "Warning Without Close Icon Sample",
                                "Error Title",
                                "Error Body",
                                linkAction = "Try again button text",
                                showIcon = false
                            )
                        )
                    )
                )
                ButtonList(
                    title = "Warning Components",
                    activities = activities,
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

@Parcelize
class WarningViewItem(
    val titleExample: String,
    val title: String,
    val body: String,
    val showIcon: Boolean = true,
    val linkAction: String? = null,
    val warningIcon: Int = R.drawable.ic_close_error,
    val warningColorIcon: Int = R.color.color_imperiya_error
) : Parcelable

class WarningItemComponentActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val warningView = intent.extras?.getParcelable("ITEM") as? WarningViewItem ?: return

        setContent {
            ImperiyaTheme {
                Scaffold(
                    topBar = {
                        DefaultTopBar(title = warningView.titleExample) {
                            finish()
                        }
                    }
                ) {
                    WarningView(
                        title = warningView.title,
                        body = warningView.body,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = it.calculateTopPadding() + 16.dp),
                        showCloseIcon = warningView.showIcon,
                        linkActionText = warningView.linkAction,
                        warningIcon = warningView.warningIcon,
                        onClickLink = {
                            Toast.makeText(
                                this,
                                "Title: ${warningView.titleExample}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                }
            }
        }
    }
}


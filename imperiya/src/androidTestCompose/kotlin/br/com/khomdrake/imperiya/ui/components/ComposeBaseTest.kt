package br.com.khomdrake.imperiya.ui.components

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule

abstract class ComposeBaseTest {

    @get:Rule
    val composeRule = createComposeRule()

}
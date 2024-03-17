package br.com.cosmind.sample.ui.bottomsheet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import br.com.arch.toolkit.delegate.viewProvider
import br.com.cosmind.imperiya.ui.bottomsheet.Item
import br.com.cosmind.imperiya.ui.bottomsheet.SpinnerBottomSheet
import br.com.cosmind.sample.R

class BottomSheetSampleActivity : AppCompatActivity(R.layout.activity_bottom_sheet_sample) {

    private val toolbar by viewProvider<Toolbar>(R.id.toolbar)
    private val spinnerButton by viewProvider<AppCompatButton>(R.id.spinner)
    private val customButton by viewProvider<AppCompatButton>(R.id.custom)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        spinnerButton.setOnClickListener {
            showSpinnerActionSheet()
        }

        customButton.setOnClickListener {
            showCustomActionSheet()
        }
    }

    private fun showSpinnerActionSheet() {
        SpinnerBottomSheet()
            .apply {
                setTitleText("Spinner Bottom Sheet")
                setBodyText("Spinner Bottom Sheet Body ahsuahsuahsuahsu")
                setItems(
                    listOf(
                        "Vin",
                        "Logan",
                        "Rell",
                        "Maker",
                        "Dalinar"
                    ).map { Item(it, it) }
                )
                setOnClickConfirm {
                    dismiss()
                }
                setButtonText("Confirm")
            }
            .show(supportFragmentManager, "showSpinnerActionSheet")
    }

    private fun showCustomActionSheet() {
        CustomActionSheet(canDismiss = false)
            .show(supportFragmentManager, "showCustomActionSheet")
    }

}
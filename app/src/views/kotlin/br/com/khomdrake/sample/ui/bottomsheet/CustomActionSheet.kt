package br.com.khomdrake.sample.ui.bottomsheet

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import br.com.arch.toolkit.delegate.viewProvider
import br.com.khomdrake.imperiya.ui.bottomsheet.RoundedBottomSheetDialogFragment
import br.com.khomdrake.sample.R

class CustomActionSheet(
    canDismiss: Boolean = false
) : RoundedBottomSheetDialogFragment(canDismiss) {

    private val button: AppCompatButton by viewProvider(R.id.close_button)

    override val layoutRes: Int
        get() = R.layout.custom_action_sheet

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            dismiss()
        }
    }
}
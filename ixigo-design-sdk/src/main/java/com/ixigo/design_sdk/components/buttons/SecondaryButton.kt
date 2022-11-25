package com.ixigo.design_sdk.components.buttons

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design_sdk.components.buttons.base.BaseButton
import com.ixigo.design_sdk.components.buttons.composable.ComposableButton
import com.ixigo.design_sdk.components.buttons.styles.Colors
import com.ixigo.design_sdk.components.buttons.styles.Shapes
import com.ixigo.design_sdk.components.buttons.styles.Sizes

class SecondaryButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseButton(context, attrs, defStyleAttr) {

    private fun mapSecStyle(colors: Colors) = when (colors) {
        Colors.Blue -> Colors.BlueSecondary
        Colors.Disabled -> Colors.Disabled
        Colors.Error -> Colors.ErrorSecondary
        Colors.Extension -> Colors.ExtensionSecondary
        Colors.Orange -> Colors.OrangeSecondary
        Colors.Success -> Colors.SuccessSecondary
        Colors.Warning -> Colors.WarningSecondary
        else -> Colors.OrangeSecondary
    }

    public override fun  setStyle(shapes: Shapes, colors: Colors, sizes: Sizes) {
        super.setStyle(shapes, colors, sizes)
    }

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindow
        )
        with(state.value) {
            ComposableButton(
                text,
                mapSecStyle(colors),
                shapes,
                sizes,
                isEnabled,
                startDrawableState.value,
                endDrawableState.value,
                onClick
            )
        }
    }
}
package com.ixigo.design_sdk.components.buttons

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design_sdk.components.buttons.base.BaseButton
import com.ixigo.design_sdk.components.buttons.composable.ComposableTextButton
import com.ixigo.design_sdk.components.buttons.styles.Colors
import com.ixigo.design_sdk.components.buttons.styles.Shapes
import com.ixigo.design_sdk.components.buttons.styles.Sizes

class TertiaryButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseButton(context, attrs, defStyleAttr) {

    private fun mapTertiaryStyle(colors: Colors) = when (colors) {
        Colors.Blue -> Colors.BlueTertiary
        Colors.Disabled -> Colors.Disabled
        Colors.Error -> Colors.ErrorTertiary
        Colors.Extension -> Colors.ExtensionTertiary
        Colors.Orange -> Colors.OrangeTertiary
        Colors.Success -> Colors.SuccessTertiary
        Colors.Warning -> Colors.WarningTertiary
        else -> Colors.OrangeTertiary
    }

    fun setStyle(colors: Colors, sizes: Sizes) {
        super.setStyle(Shapes.RegularShape, colors, sizes)
    }

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindow
        )
        with(state.value) {
            ComposableTextButton(
                text,
                mapTertiaryStyle(colors),
                sizes,
                isEnabled,
                startDrawableState.value,
                endDrawableState.value,
                onClick
            )
        }
    }
}
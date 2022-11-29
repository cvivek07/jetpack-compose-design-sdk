package com.ixigo.design_sdk.components.buttons

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design_sdk.components.buttons.base.BaseButton
import com.ixigo.design_sdk.components.buttons.composable.ComposableTextButton
import com.ixigo.design_sdk.components.styles.IxiColor
import com.ixigo.design_sdk.components.buttons.styles.ButtonShape
import com.ixigo.design_sdk.components.buttons.styles.ButtonSize

class TertiaryButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseButton(context, attrs, defStyleAttr) {

    private fun mapTertiaryStyle(colors: IxiColor) = when (colors) {
        IxiColor.Blue -> IxiColor.BlueTertiary
        IxiColor.Disabled -> IxiColor.Disabled
        IxiColor.Error -> IxiColor.ErrorTertiary
        IxiColor.Extension -> IxiColor.ExtensionTertiary
        IxiColor.Orange -> IxiColor.OrangeTertiary
        IxiColor.Success -> IxiColor.SuccessTertiary
        IxiColor.Warning -> IxiColor.WarningTertiary
        else -> IxiColor.OrangeTertiary
    }

    fun setStyle(colors: IxiColor, sizes: ButtonSize) {
        super.setStyle(ButtonShape.RegularShape, colors, sizes)
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
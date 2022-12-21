package com.ixigo.design.sdk.components.buttons

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.Dp
import com.ixigo.design.sdk.components.buttons.base.BaseButton
import com.ixigo.design.sdk.components.buttons.composable.ComposableButton
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.buttons.styles.ButtonShape
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize

class IxiSecondaryButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseButton(context, attrs, defStyleAttr) {

    private fun mapSecStyle(colors: IxiColor) = when (colors) {
        IxiColor.Blue -> IxiColor.BlueSecondary
        IxiColor.Disabled -> IxiColor.Disabled
        IxiColor.Error -> IxiColor.ErrorSecondary
        IxiColor.Extension -> IxiColor.ExtensionSecondary
        IxiColor.Orange -> IxiColor.OrangeSecondary
        IxiColor.Success -> IxiColor.SuccessSecondary
        IxiColor.Warning -> IxiColor.WarningSecondary
        else -> IxiColor.OrangeSecondary
    }

    public override fun  setStyle(shapes: ButtonShape, colors: IxiColor, sizes: ButtonSize) {
        super.setStyle(shapes, colors, sizes)
    }

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindow
        )
        with(state.value) {
            ComposableButton(
                Modifier,
                text,
                mapSecStyle(colors),
                shapes,
                sizes,
                preferredWidth,
                isEnabled,
                startDrawableState.value,
                endDrawableState.value,
                onClick
            )
        }
    }
}
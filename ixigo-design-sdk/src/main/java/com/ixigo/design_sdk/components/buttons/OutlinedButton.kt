package com.ixigo.design_sdk.components.buttons

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design_sdk.components.buttons.base.BaseButton
import com.ixigo.design_sdk.components.buttons.composable.ComposableButtonOutlined
import com.ixigo.design_sdk.components.styles.IxiColor
import com.ixigo.design_sdk.components.buttons.styles.Shapes
import com.ixigo.design_sdk.components.buttons.styles.Sizes

class OutlinedButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseButton(context, attrs, defStyleAttr) {

    public override fun  setStyle(shapes: Shapes, colors: IxiColor, sizes: Sizes) {
        super.setStyle(shapes, colors, sizes)
    }

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindow )
        with(state.value) {
            ComposableButtonOutlined(text, colors,shapes, sizes,isEnabled, startDrawableState.value, endDrawableState.value, onClick)
        }
    }
}

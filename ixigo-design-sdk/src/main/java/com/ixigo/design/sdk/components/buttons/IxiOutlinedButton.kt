package com.ixigo.design.sdk.components.buttons

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.buttons.base.BaseButton
import com.ixigo.design.sdk.components.buttons.composable.ComposableButtonOutlined
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.buttons.styles.ButtonShape
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize

class IxiOutlinedButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseButton(context, attrs, defStyleAttr) {

    public override fun setColor(color: IxiColor) {
        super.setColor(color)
    }

    public override  fun setShape(shapes: ButtonShape) {
        super.setShape(shapes)
    }

    public override fun setSize(size: ButtonSize) {
        super.setSize(size)
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

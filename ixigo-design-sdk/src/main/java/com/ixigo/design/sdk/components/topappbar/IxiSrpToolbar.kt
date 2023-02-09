package com.ixigo.design.sdk.components.topappbar

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.srp.composables.SrpModel
import com.ixigo.design.sdk.components.topappbar.base.BaseTopAppBar
import com.ixigo.design.sdk.components.topappbar.composable.SrpBar

class IxiSrpToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseTopAppBar(context, attrs, defStyleAttr) {

    fun setData(data: SrpModel) {
        val initState = state.value
        state.value = initState.copy(srpData = data)
    }

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
             ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool
        )
        with(state.value) {
            SrpBar(
                homeIcon = homeIcon,
                elevation = elevation,
                menuProvider = menuProvider,
                data = state.value.srpData
            )
        }
    }
}
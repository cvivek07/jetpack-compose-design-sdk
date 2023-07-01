package com.ixigo.design.sdk.components.topappbar

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import com.ixigo.design.sdk.components.srp.composables.SrpTitle
import com.ixigo.design.sdk.components.topappbar.base.BaseTopAppBar
import com.ixigo.design.sdk.components.topappbar.composable.SrpBar

class IxiSrpToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseTopAppBar(context, attrs, defStyleAttr) {

    fun setSrpTitle(data: SrpTitle) {
        val initState = state.value
        state.value = initState.copy(srpTitle = data)
    }

    fun setSrpSubTitle(subTitle: String){
        state.value = state.value.copy(subTitle = subTitle)
    }

    fun setOnClickListener(onClick: () -> Unit){
        val initState = state.value
        state.value = initState.copy(onClick = onClick)
    }

    @Composable
    override fun Content() {
        with(state.value) {
            SrpBar(
                homeIcon = homeIcon,
                elevation = elevation,
                menuProvider = menuProvider,
                title = srpTitle,
                subTitle = subTitle,
                onClick = state.value.onClick,
                disabledIds = disabledIds
            )
        }
    }
}
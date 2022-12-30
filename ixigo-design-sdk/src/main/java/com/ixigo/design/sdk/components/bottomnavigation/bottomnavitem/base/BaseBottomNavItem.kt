package com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.base

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.composable.BadgeType
import com.ixigo.design.sdk.components.styles.IxiColor

abstract class BaseBottomNavItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {
    protected var state = mutableStateOf(BottomNavItemState())

    fun setIcon(@DrawableRes icon: Int){
        val inState = state.value
        state.value = inState.copy(icon = icon)
    }

    fun setLabel(label: String){
        val inState = state.value
        state.value = inState.copy(label = label)
    }

    fun isSelected(selected: Boolean){
        val inState = state.value
        state.value = inState.copy(selected = selected)
    }

    fun onCLick(onClick: () -> Unit){
        val inState = state.value
        state.value = inState.copy(onClick = onClick)
    }

    fun badgeType(badgeType: BadgeType){
        val inState = state.value
        state.value = inState.copy(badgeType = badgeType)
    }

    fun badgeContent(badgeContent: String){
        val inState = state.value
        state.value = inState.copy(badgeContent = badgeContent)
    }

    fun ixiColor(ixiColor: IxiColor){
        val inState = state.value
        state.value = inState.copy(ixiColor = ixiColor)
    }


}

data class BottomNavItemState(
    @DrawableRes val icon: Int?= null,
    val label: String? = null,
    val selected: Boolean = false,
    val onClick: (() -> Unit)? = null,
    val badgeType: BadgeType? = null,
    val badgeContent: String? = null,
    val ixiColor: IxiColor? = null
)
package com.ixigo.design.sdk.components.topappbar.base

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import com.ixigo.design.sdk.components.BaseComponent

abstract class BaseTopAppBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {

}

data class AppBarState(
    @DrawableRes val homeIcon: Int = 0,
    val title: String? = null,
    val subTitle: String? = null,
    val actionText: String? = null,
    @DrawableRes val actionIcon1: Int = 0,
    @DrawableRes val actionIcon2: Int = 0
)
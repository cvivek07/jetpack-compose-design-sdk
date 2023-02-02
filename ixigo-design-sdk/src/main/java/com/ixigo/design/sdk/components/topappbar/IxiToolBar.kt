package com.ixigo.design.sdk.components.topappbar

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.MenuRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.appbar.MaterialToolbar
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.utils.DimensionUtils.dpToPx

class IxiToolBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialToolbar(context, attrs, defStyleAttr) {

//    private val appBar: IxiAppBar by lazy { IxiAppBar(context, attrs, defStyleAttr) }

    init {
        isSubtitleCentered = true
        isTitleCentered = true

        setBackgroundColor(ContextCompat.getColor(context, R.color.n0))
        setNavigationIcon(R.drawable.left_arrow)

        popupTheme = R.style.ToolbarPopupThemeOrange
        setNavigationIconTint(ContextCompat.getColor(context, R.color.n900))
        setTitleTextAppearance(context, R.style.ToolbarTitleAppearance)
        setSubtitleTextAppearance(context, R.style.ToolbarSubtitleAppearance)
    }

    fun setElevated(isElevated: Boolean) {
        elevation = if (isElevated) context.dpToPx(10) else context.dpToPx(0)
    }

    fun setMenu(@MenuRes resId: Int) {
        inflateMenu(resId)
    }
}
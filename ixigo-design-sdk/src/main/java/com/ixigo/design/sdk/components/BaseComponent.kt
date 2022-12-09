package com.ixigo.design.sdk.components

import android.content.Context
import android.util.AttributeSet
import androidx.compose.ui.platform.AbstractComposeView
import com.ixigo.design.sdk.SdkInitializer

abstract class BaseComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {
    protected val project = SdkInitializer.projectName
}

abstract class BaseComposition()
package com.ixigo.design.sdk.components.toast

import android.content.Context
import android.graphics.PixelFormat
import android.util.AttributeSet
import android.view.WindowManager
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.ViewRootForInspector
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.savedstate.SavedStateRegistryOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.imageutils.ImageData
import com.ixigo.design.sdk.components.toast.composable.ComposablePopup
import java.util.Timer
import java.util.TimerTask


private const val popupShortDuration = 3000L
private const val popupLongDuration = 6000L

class IxiToast private constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr), ViewRootForInspector {

    private constructor(context: Context, viewLifecycleOwner: LifecycleOwner) : this(context) {
        ViewTreeLifecycleOwner.set(this, viewLifecycleOwner)
        setViewTreeSavedStateRegistryOwner(viewLifecycleOwner as SavedStateRegistryOwner)
    }

    private val windowManager =
        context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

    private val state = mutableStateOf(
        ToastState(title = "")
    )

    private val params = WindowManager.LayoutParams(
        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
        WindowManager.LayoutParams.TYPE_APPLICATION_PANEL,
        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
        PixelFormat.TRANSLUCENT
    ).apply {
        x = state.value.positionX
        y = state.value.positionY
    }

    fun setTitle(title: String) {
        state.value = state.value.copy(title = title)
    }

    fun setSubtitle(subTitle: String) {
        state.value = state.value.copy(subTitle = subTitle)
    }

    fun setLeftIconDetails(
        @DrawableRes drawable: Int,
        leftIconClickListener: (() -> Unit)? = null
    ) {
        state.value = state.value.copy(
            leftIcon = ImageData.createFromRes(drawable),
            leftIconClickListener = leftIconClickListener
        )
    }

    fun setRightIconDetails(
        @DrawableRes drawable: Int,
        rightIconClickListener: (() -> Unit)? = null
    ) {
        state.value = state.value.copy(
            rightIcon = ImageData.createFromRes(drawable),
            rightIconClickListener = rightIconClickListener
        )
    }

    fun setButtonDetails(
        buttonText: String,
        buttonClickListener: (() -> Unit)? = null
    ) {
        state.value =
            state.value.copy(buttonText = buttonText, buttonClickListener = buttonClickListener)
    }

    fun setIxiToastType(
        ixiToastType: IxiToastType
    ) {
        state.value = state.value.copy(ixiToastType = ixiToastType)
    }

    fun setPositionX(
        positionX: Int
    ) {
        state.value = state.value.copy(positionX = positionX)
    }

    fun setPositionY(
        positionY: Int
    ) {
        state.value = state.value.copy(positionY = positionY)
    }

    fun setDuration(duration: IxiToastDuration) {
        state.value = state.value.copy(duration = getPopupAutoDismissDuration(duration))
    }

    fun show() {
        state.value = state.value.copy(show = true)
        windowManager.addView(this, params)
        startAutoDismissTimer()
    }

    fun hide() {
        state.value = state.value.copy(show = false)
        windowManager.removeView(this)
    }

    private fun startAutoDismissTimer() {
        state.value.duration?.let {
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    hide()
                }
            }, it)
        }
    }

    class Builder(context: Context, lifecycleOwner: LifecycleOwner) {
        private var ixiToast: IxiToast = IxiToast(context, lifecycleOwner)

        fun setTitle(title: String) = apply { ixiToast.setTitle(title) }
        fun setSubtitle(subTitle: String) = apply { ixiToast.setSubtitle(subTitle) }
        fun setLeftIcon(@DrawableRes drawable: Int, listener: (() -> Unit)? = null) =
            apply {
                ixiToast.setLeftIconDetails(drawable, listener)
            }

        fun setRightIcon(@DrawableRes drawable: Int, listener: (() -> Unit)? = null) =
            apply {
                ixiToast.setRightIconDetails(drawable, listener)
            }

        fun setButton(text: String, listener: (() -> Unit)? = null) =
            apply {
                ixiToast.setButtonDetails(text, listener)
            }

        fun setType(type: IxiToastType) = apply { ixiToast.setIxiToastType(type) }
        fun setXPosition(x: Int) = apply { ixiToast.setPositionX(x) }
        fun setYPosition(y: Int) = apply { ixiToast.setPositionY(y) }

        fun setDuration(duration: IxiToastDuration) = apply { ixiToast.setDuration(duration) }

        fun build(): IxiToast {
            return ixiToast
        }
    }

    @Composable
    override fun Content() {
        ComposablePopup(
            heading = state.value.title,
            subHeading = state.value.subTitle,
            leftIcon = state.value.leftIcon,
            leftIconClickListener = state.value.leftIconClickListener,
            rightIcon = state.value.rightIcon,
            rightIconClickListener = state.value.rightIconClickListener,
            buttonText = state.value.buttonText,
            buttonClickListener = state.value.buttonClickListener,
            ixiToastType = state.value.ixiToastType,
            positionX = state.value.positionX,
            positionY = state.value.positionY,
            show = state.value.show
        )
    }
}

enum class IxiToastType {
    BLACK, WHITE, RED, GREEN, YELLOW
}

enum class IxiToastDuration {
    SHORT, LONG
}

fun getPopupAutoDismissDuration(popupDuration: IxiToastDuration): Long {
    return when (popupDuration) {
        IxiToastDuration.SHORT -> popupShortDuration
        IxiToastDuration.LONG -> popupLongDuration
    }
}

data class ToastState(
    val title: String,
    val subTitle: String? = null,
    val leftIcon: ImageData? = null,
    val leftIconClickListener: (() -> Unit)? = null,
    val rightIcon: ImageData? = null,
    val rightIconClickListener: (() -> Unit)? = null,
    val buttonText: String? = null,
    val buttonClickListener: (() -> Unit)? = null,
    val ixiToastType: IxiToastType = IxiToastType.WHITE,
    val positionX: Int = 0,
    val positionY: Int = 0,
    val duration: Long? = null,
    val show: Boolean = true
)
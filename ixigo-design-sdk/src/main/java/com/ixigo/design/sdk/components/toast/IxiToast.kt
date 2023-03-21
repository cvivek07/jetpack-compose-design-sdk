package com.ixigo.design.sdk.components.toast

import android.content.Context
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.WindowManager
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
import java.util.*


private const val popupShortDuration = 3000L
private const val popupLongDuration = 6000L

class IxiToast @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr), ViewRootForInspector {

    constructor(context: Context, viewLifecycleOwner: LifecycleOwner) : this(context) {
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
        drawable: Drawable,
        leftIconClickListener: (() -> Unit)? = null
    ) {
        state.value = state.value.copy(
            leftIcon = ImageData.createFromDrawable(drawable),
            leftIconClickListener = leftIconClickListener
        )
    }

    fun setRightIconDetails(
        drawable: Drawable,
        rightIconClickListener: (() -> Unit)? = null
    ) {
        state.value = state.value.copy(
            rightIcon = ImageData.createFromDrawable(drawable),
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

    fun setPosition(
        positionX: Int,
        positionY: Int
    ) {
        state.value = state.value.copy(positionX = positionX, positionY = positionY)
    }

    fun setDuration(duration: IxiToastDuration) {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                state.value = state.value.copy(show = false)
            }

        }, getPopupAutoDismissDuration(duration))
    }

    fun show() {
        state.value = state.value.copy(show = true)
        windowManager.addView(this, params)
    }

    fun hide() {
        state.value = state.value.copy(show = false)
        windowManager.removeView(this)
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
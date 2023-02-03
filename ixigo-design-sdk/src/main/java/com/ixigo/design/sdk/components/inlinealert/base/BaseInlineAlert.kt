package com.ixigo.design.sdk.components.inlinealert.base

import android.animation.LayoutTransition
import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.SdkManager
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.styles.IxiColor

abstract class BaseInlineAlert @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {
    protected var state = mutableStateOf(InlineAlertState())

    init {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.BaseInlineAlert)
        try {
            val logo = typedArray.getResourceId(R.styleable.BaseInlineAlert_android_logo, -1)
            if(logo!=-1){
                setLogo(logo)
            }
            val heading = typedArray.getString(R.styleable.BaseInlineAlert_heading)
            if(heading!=null){
                setHeading(heading)
            }
            val text = typedArray.getString(R.styleable.BaseButton_android_text)
            if(text!=null){
                setText(text)
            }
            val rightIcon = typedArray.getResourceId(R.styleable.BaseInlineAlert_android_drawableEnd, -1)
            if(logo!=-1){
                setRightIcon(rightIcon)
            }
            val rightButtonText = typedArray.getString(R.styleable.BaseInlineAlert_rightButtonText)
            if(rightButtonText!=null){
                setRightButtonText(rightButtonText)
            }
            val leftButtonText = typedArray.getString(R.styleable.BaseInlineAlert_leftButtonText)
            if(leftButtonText!=null){
                setLeftButtonText(leftButtonText)
            }
            val colorEnum = typedArray.getInt(R.styleable.BaseInlineAlert_inlineAlertType, -1)
            if(colorEnum!=-1){
                InlineAlertType.fromId(colorEnum)?.let {
                    setColor(mapTypeToColor(it))
                }
            }
        } finally {
            typedArray.recycle()
        }

    }

    fun setLogo(@DrawableRes logo: Int){
        val initState = state.value
        state.value = initState.copy(logo = logo)
    }

    fun setHeading(heading:String){
        val initState = state.value
        state.value = initState.copy(heading = heading)
    }

    fun setText(text:String){
        val initState = state.value
        state.value = initState.copy(text = text)
    }

    fun setRightIcon(@DrawableRes icon: Int){
        val initState = state.value
        state.value = initState.copy(rightIcon = icon)
    }

    open fun setRightIconClickListener(clickListener:(()->Unit)?){
        val initState = state.value
        state.value = initState.copy(onRightIconClickListener = clickListener)
    }

    fun setRightButtonText(text:String){
        val initState = state.value
        state.value = initState.copy(rightButtonText = text)
    }

    fun setLeftButtonText(text:String){
        val initState = state.value
        state.value = initState.copy(leftButtonText = text)
    }

    open fun setRightButtonClickListener(onClick:()->Unit){
        val initState = state.value
        state.value = initState.copy(rightButtonClickListener = onClick)
    }

    open fun setLeftButtonClickListener(onClick:()->Unit){
        val initState = state.value
        state.value = initState.copy(leftButtonClickListener = onClick)
    }

    open fun setColor(ixiColor: IxiColor){
        val initState = state.value
        state.value = initState.copy(ixiColor = ixiColor)
    }

    protected fun mapTypeToColor(inlineAlertType:InlineAlertType):IxiColor{
       return when(inlineAlertType){
            InlineAlertType.YELLOW -> IxiColor.Extra(bg = R.color.y50, text = R.color.y700, pressed = R.color.y700)
            InlineAlertType.PURPLE -> IxiColor.Extra(bg = R.color.p50, text = R.color.p500, pressed = R.color.p400)
            InlineAlertType.RED -> IxiColor.Extra(bg = R.color.r50, text = R.color.r500, pressed = R.color.r400)
            InlineAlertType.GREEN -> IxiColor.Extra(bg = R.color.g50, text = R.color.g500, pressed = R.color.g400)
            InlineAlertType.BLUE -> IxiColor.Extra(bg = R.color.b50, text = R.color.b500, pressed = R.color.b400)
            InlineAlertType.NEUTRAL -> IxiColor.Extra(bg = R.color.n40, text = R.color.n600, pressed = R.color.n800)
        }
    }

    fun dismiss(){
        (parent as? ViewGroup)?.let {
            val prevTransition = it.layoutTransition
            val lt = LayoutTransition()
            lt.disableTransitionType(LayoutTransition.DISAPPEARING)
            it.layoutTransition = lt
            it.removeView(this)
            it.layoutTransition = prevTransition
        }
    }

}

enum class InlineAlertType(val identifier:Int){
    YELLOW(0),
    PURPLE(1),
    RED(2),
    GREEN(3),
    BLUE(4),
    NEUTRAL(5);
    companion object {
        fun fromId(int: Int):InlineAlertType? = values().find { it.identifier == int }
    }

}

data class InlineAlertState(
    @DrawableRes val logo: Int? = null,
    val heading:String? = null,
    val text:String = "",
    @DrawableRes val rightIcon:Int? = null,
    val onRightIconClickListener: (()->Unit)? = null,
    val ixiColor: IxiColor = SdkManager.getConfig().project.color,
    val leftButtonText:String? = null,
    val leftButtonClickListener:() -> Unit = {},
    val rightButtonText:String? = null,
    val rightButtonClickListener:() -> Unit = {},
)
package com.ixigo.design.sdk.components.inlinealert.base

import android.animation.LayoutTransition
import android.content.Context
import android.text.Layout.Alignment
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.SdkManager
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiInlineAlertColor

/**
 * Abstract class for a custom Inline Alert View in Android
 *
 * @param context The Context the view is running in, through which it can
 * access the current theme, resources, etc.
 * @param attrs The attributes of the XML tag that is inflating the view.
 * @param defStyleAttr An attribute in the current theme that contains a
 * reference to a style resource that supplies default values for
 * the view. Can be 0 to not look for defaults.
 */
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
            val actionIcon = typedArray.getResourceId(R.styleable.BaseInlineAlert_actionIcon, -1)
            if(actionIcon!=-1){
                setActionIcon(actionIcon)
            }
            val rightButtonText = typedArray.getString(R.styleable.BaseInlineAlert_rightButtonText)
            if(rightButtonText!=null){
                setRightButtonText(rightButtonText)
            }
            val leftButtonText = typedArray.getString(R.styleable.BaseInlineAlert_leftButtonText)
            if(leftButtonText!=null){
                setLeftButtonText(leftButtonText)
            }
            val colorEnum = typedArray.getInt(R.styleable.BaseInlineAlert_ixiColor, -1)
            if(colorEnum!=-1){
                this.setColor(mapTypeToColor(colorEnum))
            }
            val buttonColor = typedArray.getResourceId(R.styleable.BaseInlineAlert_buttonColor, -1)
            if(buttonColor!=-1){
                setButtonColor(buttonColor)
            }
            textAlignment(mapAlignment(typedArray.getInt(R.styleable.BaseInlineAlert_contentAlignment, 0)))
            headingAlignment(mapAlignment(typedArray.getInt(R.styleable.BaseInlineAlert_contentAlignment, 0)))
        } finally {
            typedArray.recycle()
        }

    }

    /**
     * Set the logo of the inline alert view
     *
     * @param logo The drawable resource id of the logo
     */
    fun setLogo(@DrawableRes logo: Int){
        val initState = state.value
        state.value = initState.copy(logo = logo)
    }

    /**
     * Set the heading of the inline alert view
     *
     * @param heading The heading text
     */
    fun setHeading(heading:String){
        val initState = state.value
        state.value = initState.copy(heading = heading)
    }

    /**
     * Set the text of the inline alert view
     *
     * @param text The text
     */
    fun setText(text:String){
        val initState = state.value
        state.value = initState.copy(text = text)
    }

    /**
     * Set the right icon of the inline alert view
     *
     * @param icon The drawable resource id of the right icon
     */
    fun setActionIcon(@DrawableRes icon: Int){
        val initState = state.value
        state.value = initState.copy(actionIcon = icon)
    }

    /**
     * Set the click listener for the right icon of the inline alert view
     *
     * @param clickListener The click listener for the right icon
     */
    open fun setActionIconClickListener(clickListener:(()->Unit)?){
        val initState = state.value
        state.value = initState.copy(onActionIconClickListener = clickListener)
    }


    /**
     * Set the text of the right button of the inline alert view
     *
     * @param text The text of the right button
     */
    fun setRightButtonText(text:String){
        val initState = state.value
        state.value = initState.copy(rightButtonText = text)
    }

    /**
     * Set the text of the left button of the inline alert view
     *
     * @param text The text of the left button
     */
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

    /**
     * Sets the color type of chip among [IxiColor]
     * can also be directly used from xml as app:inlineAlertType="neutral"
     */
    open fun setColor(ixiColor: IxiColor){
        val initState = state.value
        state.value = initState.copy(ixiColor = ixiColor)
    }

    /**
     * Sets the alignment
     * value can be either
     * ALIGN_NORMAL, ALIGN_OPPOSITE, ALIGN_CENTER
     * @param alignment alignment of header text
     */
    fun headingAlignment(alignment: Alignment){
        val initState = state.value
        state.value = initState.copy(headingAlignment = alignment)
    }

    /**
     * Sets the alignment
     * value can be either
     * ALIGN_NORMAL, ALIGN_OPPOSITE, ALIGN_CENTER
     * @param alignment alignment of text
     */
    fun textAlignment(alignment: Alignment){
        val initState = state.value
        state.value = initState.copy(textAlignment = alignment)
    }

    /**
     * Sets the button color
     * @param [@ColorRes] int
     */
    fun setButtonColor(@ColorRes ixiColor: Int){
        val initState = state.value
        state.value = initState.copy(buttonColor = ixiColor)
    }

    private fun mapTypeToColor(int:Int):IxiColor{
       return when(int){
           0 -> IxiInlineAlertColor.Warning
           1 -> IxiInlineAlertColor.Extension
           2 -> IxiInlineAlertColor.Error
           3 -> IxiInlineAlertColor.Success
           4 -> IxiInlineAlertColor.Blue
           5 -> IxiInlineAlertColor.Neutral
           6 -> IxiInlineAlertColor.Orange
           else -> {
               IxiInlineAlertColor.Neutral
           }
       }
    }

    protected fun mapAlignment(int: Int): Alignment{
        return when(int){
            0-> Alignment.ALIGN_NORMAL
            1-> Alignment.ALIGN_OPPOSITE
            2-> Alignment.ALIGN_CENTER
            else -> Alignment.ALIGN_NORMAL
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

data class InlineAlertState(
    @DrawableRes val logo: Int? = null,
    val heading:String? = null,
    val text:String = "",
    @DrawableRes val actionIcon:Int? = null,
    val onActionIconClickListener: (()->Unit)? = null,
    val ixiColor: IxiColor = SdkManager.getConfig().project.color,
    val leftButtonText:String? = null,
    val leftButtonClickListener:() -> Unit = {},
    val rightButtonText:String? = null,
    val rightButtonClickListener:() -> Unit = {},
    val headingAlignment: Alignment = Alignment.ALIGN_NORMAL,
    val textAlignment: Alignment = Alignment.ALIGN_NORMAL,
    @ColorRes val buttonColor: Int? = null,
)
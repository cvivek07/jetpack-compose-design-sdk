package com.ixigo.design.sdk.components.stickyalert.base

import android.animation.LayoutTransition
import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.compose.runtime.mutableStateOf
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.SdkManager
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.imageutils.ImageData
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiStickyAlertColor
import com.ixigo.design.sdk.utils.Utils

/**
 * Abstract class for a custom Sticky Alert View in Android
 *
 * @param context The Context the view is running in, through which it can
 * access the current theme, resources, etc.
 * @param attrs The attributes of the XML tag that is inflating the view.
 * @param defStyleAttr An attribute in the current theme that contains a
 * reference to a style resource that supplies default values for
 * the view. Can be 0 to not look for defaults.
 */
abstract class BaseStickyAlert @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {
    protected var state = mutableStateOf(StickyAlertState())

    init {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.BaseStickyAlert)
        try {
            val rightIcon = typedArray.getResourceId(R.styleable.BaseStickyAlert_rightIcon, -1)
            if(rightIcon!=-1){
                setRightIcon(ImageData.createFromRes(rightIcon))
            }
            val leftIcon = typedArray.getResourceId(R.styleable.BaseStickyAlert_leftIcon, -1)
            if(leftIcon!=-1){
                setLeftIcon(ImageData.createFromRes(leftIcon))
            }

            val text = typedArray.getString(R.styleable.BaseStickyAlert_android_text)
            if(text!=null){
                setText(text)
            }
            val rightButtonText = typedArray.getString(R.styleable.BaseStickyAlert_rightButtonText)
            if(rightButtonText!=null){
                setRightButtonText(rightButtonText)
            }
            val leftButtonText = typedArray.getString(R.styleable.BaseStickyAlert_leftButtonText)
            if(leftButtonText!=null){
                setLeftButtonText(leftButtonText)
            }
            val colorEnum = typedArray.getInt(R.styleable.BaseStickyAlert_ixiColor, -1)
            if(colorEnum!=-1){
                this.setColor(mapTypeToColor(colorEnum))
            }
            val elevation = typedArray.getDimensionPixelSize(R.styleable.BaseStickyAlert_android_elevation, -1)
            if(elevation!=-1){
                this.setViewElevation(Utils.convertPixelsToDp(elevation.toFloat(), context = context).toInt())
            }
            val buttonColor = typedArray.getResourceId(R.styleable.BaseStickyAlert_buttonColor, -1)
            if(buttonColor!=-1){
                setButtonColor(buttonColor)
            }
            setArrangement(mapArrangementToValue(typedArray.getInt(R.styleable.BaseStickyAlert_arrangement, 1)))
        } finally {
            typedArray.recycle()
        }

    }

    /**
     * Set the right icon of the sticky alert view
     */
    fun setRightIcon(rightIcon: ImageData){
        val initState = state.value
        state.value = initState.copy(rightIcon = rightIcon)
    }

    /**
     * Set the left icon of the sticky alert view
     */
    fun setLeftIcon(leftIcon: ImageData){
        val initState = state.value
        state.value = initState.copy(leftIcon = leftIcon)
    }

    /**
     * Set the text of the sticky alert view
     *
     * @param text The text
     */
    fun setText(text:String){
        val initState = state.value
        state.value = initState.copy(text = text)
    }


    /**
     * Set the text of the right button of the sticky alert view
     *
     * @param text The text of the right button
     */
    fun setRightButtonText(text:String){
        val initState = state.value
        state.value = initState.copy(rightButtonText = text)
    }

    /**
     * Set the text of the left button of the sticky alert view
     *
     * @param text The text of the left button
     */
    fun setLeftButtonText(text:String){
        val initState = state.value
        state.value = initState.copy(leftButtonText = text)
    }

    /**
     * Sets whether sticky alert is spaced or not
     */
    private fun setSpaced(isSpaced:Boolean){
        val initState = state.value
        state.value = initState.copy(spaced = isSpaced)
    }

    /**
     * Sets arrangement for sticky alert
     */
    fun setArrangement(arrangement: Arrangement){
       when(arrangement){
           Arrangement.NORMAL -> setSpaced(false)
           Arrangement.SPACED -> setSpaced(true)
       }
    }

    /**
     * Sets arrangement for sticky alert
     */
    fun setViewElevation(elevation: Int){
        val initState = state.value
        state.value = initState.copy(elevation = elevation)
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
     * Sets the color type of sticky alert among [IxiColor]
     * can also be directly used from xml as app:stickyAlertType="error"
     */
    open fun setColor(ixiColor: IxiColor){
        val initState = state.value
        state.value = initState.copy(ixiColor = ixiColor)
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
            0 -> IxiStickyAlertColor.Warning
            1 -> IxiStickyAlertColor.Extension
            2 -> IxiStickyAlertColor.Error
            3 -> IxiStickyAlertColor.Success
            4 -> IxiStickyAlertColor.Blue
            5 -> IxiStickyAlertColor.Neutral
            6 -> IxiStickyAlertColor.Orange
            else -> {
                IxiStickyAlertColor.Neutral
            }
        }
    }

    private fun mapArrangementToValue(int:Int):Arrangement{
        return when(int){
            0 -> Arrangement.NORMAL
            1 -> Arrangement.SPACED
            else -> {
                Arrangement.SPACED
            }
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

enum class Arrangement{
    NORMAL,
    SPACED
}

data class StickyAlertState(
    val text:String = "",
    val rightIcon: ImageData? = null,
    val leftIcon: ImageData? = null,
    val leftButtonText:String? = null,
    val leftButtonClickListener:() -> Unit = {},
    val rightButtonText:String? = null,
    val rightButtonClickListener:() -> Unit = {},
    val ixiColor: IxiColor = SdkManager.getConfig().project.color,
    @ColorRes val buttonColor: Int? = null,
    val spaced:Boolean = true,
    val elevation:Int? = null
)
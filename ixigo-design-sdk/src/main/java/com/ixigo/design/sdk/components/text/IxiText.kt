package com.ixigo.design.sdk.components.text

import android.content.Context
import android.text.Spanned
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.font.FontWeight.Companion.W900
import androidx.compose.ui.text.style.TextOverflow
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.buttons.composable.updateHeight
import com.ixigo.design.sdk.components.buttons.composable.updateWidth
import com.ixigo.design.sdk.components.inputfields.IxiLinedInputField
import com.ixigo.design.sdk.components.inputfields.IxiOutlinedInputField
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.styles.IxiTypography.Body.Small.applyItalics
import com.ixigo.design.sdk.components.styles.IxiTypography.Body.Small.applyStrikeThrough
import com.ixigo.design.sdk.components.styles.IxiTypography.Body.Small.applyUnderLine
import com.ixigo.design.sdk.components.text.composable.TypographyText


/**
 * A user interface element that displays text to the user.
 * To provide user-editable text, see [IxiLinedInputField] and [IxiOutlinedInputField].
 *
 * The following code sample shows a typical use, with an XML layout
 * and code to modify the contents of the text view:
 *
 * ```
 * <LinearLayout
 * xmlns:android="http://schemas.android.com/apk/res/android"
 * android:layout_width="match_parent"
 * android:layout_height="match_parent"&gt;
 *    <com.ixigo.design.sdk.components.text.IxiText
 *        android:id="@+id/text_view_id"
 *        android:layout_height="wrap_content"
 *        android:layout_width="wrap_content"
 *        android:textColor="@color/o700"
 *        android:text="@string/hello" >
 * </LinearLayout>
 * ```
 *
 * This code sample demonstrates how to modify the contents of the text view
 * defined in the previous XML layout:
 *
 * ```
 * public class MainActivity extends Activity {
 *
 *    protected void onCreate(Bundle savedInstanceState) {
 *         super.onCreate(savedInstanceState);
 *         setContentView(R.layout.activity_main);
 *         final IxiText helloTextView = (IxiText) findViewById(R.id.text_view_id);
 *         helloTextView.setText("Hello World");
 *     }
 * }
 * ```
 *
 * To customize the appearance of IxiText, Modify [IxiTypography]'s properties.
 *
 * ```
 * IxiTypography.Body.XSmall.regular.copy(fontSize = 20.dp)
 * IxiTypography.Body.XSmall.regular.copy(letterSpacing = 1.sp,)
 * IxiTypography.Body.XSmall.regular.copy(lineHeight = 23.4.sp,)
 * IxiTypography.Body.XSmall.regular.copy(fontWeight = W500,)
 * IxiTypography.Body.XSmall.regular.copy(fontFamily = IxiFamily)
 * ```
 *
 * @since 1.0
 */
class IxiText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {

    //    private var textStyle = TextStyle(fontFamily = IxiFamily)
    private var textColorRes: Int
    private var defaultTypography: IxiTypography.TypographyType = IxiTypography.Body.Medium
    private var defaultTextStyle = defaultTypography.regular

    private val state = mutableStateOf(
        TextState(
            text = "",
            spannedString = null,
            textStyle = defaultTextStyle,
            color = null,
            onClick = null,
            maxLines = Int.MAX_VALUE,
            vAlignment = Alignment.CenterVertically,
            hAlignment = Alignment.CenterHorizontally,
            overflow = TextOverflow.Visible
        )
    )

    init {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.IxiText)
        try {
            val text = typedArray.getString(R.styleable.IxiText_android_text) ?: ""
            setText(text)

            textColorRes = typedArray.getColor(R.styleable.IxiText_android_textColor, 0)
            setTextColor(textColorRes)
            val maxLines = typedArray.getInt(R.styleable.IxiText_android_maxLines, Int.MAX_VALUE)
            setMaxLines(maxLines)
            val overflow = mapTextOverflowToEnum(typedArray.getInt(R.styleable.IxiText_ixiTextOverflow, 0))
            setOverflow(overflow)

            val textDisplayType = typedArray.getInt(
                R.styleable.IxiText_textDisplayType,
                TextDisplayType.BODY_MEDIUM.ordinal
            )
            val textWeight = typedArray.getInt(
                R.styleable.IxiText_textWeight,
                TextWeight.REGULAR.ordinal
            )
            setTextDisplayType(textDisplayType)
            setTextWeight(TextWeight.values()[textWeight])

            val hAlign = when (typedArray.getInt(R.styleable.IxiText_horizontalAlignment, 1)) {
                0 -> Alignment.Start
                2 -> Alignment.End
                else -> Alignment.CenterHorizontally
            }
            setHorizontalAlignment(hAlign)

            val vAlign = when (typedArray.getInt(R.styleable.IxiText_verticalAlignment, 1)) {
                0 -> Alignment.Bottom
                2 -> Alignment.Top
                else -> Alignment.CenterVertically
            }
            setVerticalAlignment(vAlign)

            val underline = typedArray.getBoolean(R.styleable.IxiText_underline, false)
            if (underline) setUnderLine()

            val strikeThrough = typedArray.getBoolean(R.styleable.IxiText_strikeThrough, false)
            if (strikeThrough) setStrikeThrough()

            val italics = typedArray.getBoolean(R.styleable.IxiText_italics, false)
            if (italics) setItalics()

            state.value = state.value.copy(textStyle = defaultTextStyle)
        } finally {
            typedArray.recycle()
        }
    }

    /**
     * Sets the text to be displayed.
     */
    fun setText(text: String) {
        state.value = state.value.copy(text = text, spannedString = null)
    }

    /**
     * Set the alignment of the text Vertically. Alignment can be any of following
     * [Alignment.Top],[Alignment.CenterVertically] and [Alignment.Bottom]
     *
     * @param alignment Alignment to be set
     */
    fun setVerticalAlignment(alignment: Alignment.Vertical) {
        state.value = state.value.copy(vAlignment = alignment)
    }

    /**
     * Set the alignment of the text Horizontally. Alignment can be any of following
     * [Alignment.Start],[Alignment.CenterHorizontally] and [Alignment.End]
     *
     * @param alignment Alignment to be set
     */
    fun setHorizontalAlignment(alignment: Alignment.Horizontal) {
        state.value = state.value.copy(hAlignment = alignment)
    }

    /**
     * Sets the Html String as Text
     *
     * @param html The Html String to be set
     */
    fun setHtmlText(html: String) {
        val spannedS =
            HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY, null, null)
        state.value = state.value.copy(spannedString = spannedS, text = null)
    }

    /**
     * Sets the html text from String resources. It will convert the resource to HTMl.
     * If No Supported Html tag is available in res then the res is set as simple String
     *
     * @param res Id of the String resource to be set
     */
    fun setHtmlText(@StringRes res: Int) {
        val string = resources.getText(res)
        if (string is Spanned) {
            state.value = state.value.copy(spannedString = string as? Spanned)
        } else {
            state.value = state.value.copy(text = string.toString())
        }
    }

    /**
     * Set the typography for this text
     */
    fun setTypography(typo: TextStyle) {
        val t = if (textColorRes != 0) {
            typo.copy(color = Color(textColorRes))
        } else {
            typo
        }
        state.value = state.value.copy(textStyle = t)
    }

    private fun setTextDisplayType(displayType: Int) {
        setTypographyType(TextDisplayType.values()[displayType])
    }

    enum class TextDisplayType {
        DISPLAY_LARGE, H1, H2, H3, H4, H5, H6, BODY_LARGE, BODY_MEDIUM, BODY_SMALL, BODY_XSMALL
    }

    enum class TextWeight(val weight: FontWeight) {
        BOLD(W900), MEDIUM(W700), REGULAR(W500)
    }

    fun setUnderLine() {
        defaultTextStyle = defaultTextStyle.applyUnderLine()
    }

    fun setStrikeThrough() {
        defaultTextStyle = defaultTextStyle.applyStrikeThrough()
    }

    fun setItalics() {
        defaultTextStyle = defaultTextStyle.applyItalics()
    }

    fun setTextWeight(weight: TextWeight) {
        defaultTextStyle = when (weight) {
            TextWeight.BOLD -> defaultTypography.bold
            TextWeight.MEDIUM -> defaultTypography.medium
            TextWeight.REGULAR -> defaultTypography.regular
        }
    }

    private fun setTypographyType(textType: TextDisplayType) {
        defaultTypography = when (textType) {
            TextDisplayType.DISPLAY_LARGE -> IxiTypography.Heading.DisplayLarge
            TextDisplayType.H1 -> IxiTypography.Heading.H1
            TextDisplayType.H2 -> IxiTypography.Heading.H2
            TextDisplayType.H3 -> IxiTypography.Heading.H3
            TextDisplayType.H4 -> IxiTypography.Heading.H4
            TextDisplayType.H5 -> IxiTypography.Heading.H5
            TextDisplayType.H6 -> IxiTypography.Heading.H6
            TextDisplayType.BODY_LARGE -> IxiTypography.Body.Large
            TextDisplayType.BODY_MEDIUM -> IxiTypography.Body.Medium
            TextDisplayType.BODY_SMALL -> IxiTypography.Body.Small
            TextDisplayType.BODY_XSMALL -> IxiTypography.Body.XSmall
        }
    }

    /**
     * Set the text color for the Text
     *
     * @param color Provide the color to be set on String. Do not provide the direct [ColorRes].
     * Provide color associated with a particular resource ID like following
     * ```
     * setTextColor(ContextCompat.getColor(requireContext(),R.color.g300))
     * ```
     */
    fun setTextColor(@ColorInt color: Int) {
        textColorRes = color
        val style = state.value.textStyle.copy(color = Color(color))
        state.value = state.value.copy(textStyle = style)
    }

    /**
     * Set the text color for the Text
     *
     * @param color Provide the color resource ID to be set on String.
     * ```
     * setTextColorRes(R.color.g300)
     * ```
     */
    fun setTextColorRes(@ColorRes color: Int) {
        setTextColor(ContextCompat.getColor(context, color))
    }

    fun setMaxLines(lines: Int) {
        state.value = state.value.copy(maxLines = lines)
    }

    fun setOverflow(textOverflow: TextOverflow) {
        state.value = state.value.copy(overflow = textOverflow)
    }

    /**
     * provide the text value
     */
    fun getText() = state.value.text
    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
        val inState = state.value
        state.value = inState.copy(onClick = { l?.onClick(this) })
    }

    private fun mapTextOverflowToEnum(int: Int): TextOverflow {
        return when (int) {
            0 -> TextOverflow.Visible
            1 -> TextOverflow.Ellipsis
            2 -> TextOverflow.Clip
            else -> TextOverflow.Clip
        }
    }

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool
        )
        val stateValue = remember { state }
        val modifier = if (stateValue.value.onClick != null) {
            Modifier.clickable {
                stateValue.value.onClick!!.invoke()
            }
        } else {
            Modifier
        }
            .updateWidth(preferredWidth)
            .updateHeight(preferredHeight)
            .wrapContentHeight(align = stateValue.value.vAlignment)
            .wrapContentWidth(align = stateValue.value.hAlignment)

        if (stateValue.value.text != null) {
            TypographyText(
                text = stateValue.value.text!!,
                textStyle = stateValue.value.textStyle,
                modifier = modifier,
                maxLines = stateValue.value.maxLines,
                overflow = stateValue.value.overflow
            )
        }
        if (stateValue.value.spannedString != null) {
            TypographyText(
                spanned = stateValue.value.spannedString!!,
                textStyle = stateValue.value.textStyle,
                modifier = modifier,
                maxLines = stateValue.value.maxLines,
                overflow = stateValue.value.overflow,
            )
        }

    }
}

data class TextState(
    val text: String? = null,
    val spannedString: Spanned? = null,
    val textStyle: TextStyle,
    @ColorInt val color: Int?,
    val maxLines: Int,
    val overflow: TextOverflow,
    val onClick: (() -> Unit)?,
    val vAlignment: Alignment.Vertical,
    val hAlignment: Alignment.Horizontal,
)
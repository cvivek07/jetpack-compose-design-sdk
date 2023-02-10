package com.ixigo.design.sdk.components.text

import android.content.Context
import android.text.Spanned
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.inputfields.IxiLinedInputField
import com.ixigo.design.sdk.components.inputfields.IxiOutlinedInputField
import com.ixigo.design.sdk.components.styles.IxiTypography
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

    private var textColorRes: Int
    private val state = mutableStateOf(
        TextState("", null, IxiTypography.Heading.DisplayLarge.regular, null, Int.MAX_VALUE, TextOverflow.Clip, {})
    )

    init {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.IxiText)
        try {
            val text = typedArray.getString(R.styleable.IxiText_android_text) ?: ""
            setText(text)
            textColorRes = typedArray.getColor(R.styleable.IxiText_android_textColor, 0)
            setTextColor(textColorRes)
            val maxLines = typedArray.getInt(R.styleable.IxiText_android_maxLines, 1)
            setMaxLines(maxLines)
            val overflow = mapTextOverflowToEnum(typedArray.getInt(R.styleable.IxiText_ixiTextOverflow, 0))
            setOverflow(overflow)
        } finally {
            typedArray.recycle()
        }
    }

    /**
     * Sets the text to be displayed.
     */
    fun setText(text: String) {
        state.value = state.value.copy(text = text)
    }

    /**
     * Sets the Html String as Text
     *
     * @param html The Html String to be set
     */
    fun setHtmlText(html: String) {
        val spannedS =
            HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY, null, null)
        state.value = state.value.copy(spannedString = spannedS)
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

    fun setTypography(typo: TextStyle) {
        val t = if (textColorRes != 0) {
            typo.copy(color = Color(textColorRes))
        } else {
            typo
        }
        state.value = state.value.copy(textStyle = t)
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
            ViewCompositionStrategy.DisposeOnDetachedFromWindow
        )
        val modifier = if (state.value.onClick != null) {
            Modifier.clickable {
                state.value.onClick!!.invoke()
            }
        } else {
            Modifier
        }
        if (state.value.text != null) {
            TypographyText(
                text = state.value.text!!,
                textStyle = state.value.textStyle,
                modifier = modifier,
                maxLines = state.value.maxLines,
                overflow = state.value.overflow
            )
        }
        if (state.value.spannedString != null) {
            TypographyText(
                spanned = state.value.spannedString!!,
                textStyle = state.value.textStyle,
                modifier = modifier,
                maxLines = state.value.maxLines,
                overflow = state.value.overflow
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
    val onClick: (() -> Unit)?
)
package com.ixigo.design.sdk.components.buttons

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.buttons.base.BaseButton
import com.ixigo.design.sdk.components.buttons.composable.ComposablePrimaryButton
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiShape
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize

/**
 * A user interface element which has solid colored background and  user can tap or click to perform
 * an action.
 *
 * User can also set text on IxiPrimaryButton along with start and end drawables
 *
 * To display a IxiPrimaryButton in an activity, add a IxiPrimaryButton to the activity's layout XML file:
 *
 *```
 * <com.ixigo.design.sdk.components.buttons.IxiPrimaryButton
 *  android:id="@+id/button_id"
 *  android:layout_width="match_parent"
 *  android:layout_height="wrap_content"
 *  android:drawableStart="@drawable/ic_call_24"
 *  android:drawableEnd="@drawable/ic_call_24"
 *  android:text="Primary Button"/>
 * ```
 * To specify an action when the IxiPrimaryButton is pressed, set a click
 * listener on the IxiPrimaryButton object in the corresponding activity code:
 *
 *```
 * public class MyActivity extends Activity {
 *     protected void onCreate(Bundle savedInstanceState) {
 *         super.onCreate(savedInstanceState);
 *
 *         setContentView(R.layout.content_layout_id);
 *
 *         final IxiPrimaryButton ixiPrimaryButton = findViewById(R.id.button_id);
 *         ixiPrimaryButton.setStartImageDrawable(R.drawable.ic_call_24) // set start drawable
 *         ixiPrimaryButton.setEndImageDrawable(R.drawable.ic_call_24) // set end drawable
 *         ixiPrimaryButton.setOnClickListener(new View.OnClickListener() {
 *             public void onClick(View v) {
 *                 // Code here executes on main thread after user presses IxiPrimaryButton
 *             }
 *         });
 *     }
 * }
 *```
 *
 * The above snippet creates an instance of [android.view.View.OnClickListener] and wires
 * the listener to the [IxiPrimaryButton] using
 * ```setOnClickListener(View.OnClickListener)```.
 *
 * As a result, the system executes the code you write in ```onClick(View)``` after the
 * user presses the IxiPrimaryButton.
 *
 * @since 1.0
 */
class IxiPrimaryButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseButton(context, attrs, defStyleAttr) {

    public override fun setColor(color: IxiColor) {
        super.setColor(color)
    }

    public override  fun setShape(shape: IxiShape) {
        super.setShape(shape)
    }

    public override fun setSize(size: ButtonSize) {
        super.setSize(size)
    }

    @Composable
    override fun Content() {
        with(state.value) {
            ComposablePrimaryButton(
                modifier = Modifier,
                text = text,
                color = colors,
                shape = shapes,
                size = sizes,
                isEnabled = isEnabled,
                startDrawable = startDrawableState.value,
                endDrawable = endDrawableState.value,
                onClick = onClick
            )
        }
    }
}

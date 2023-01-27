package com.ixigo.design.sdk.components.buttons

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.buttons.base.BaseButton
import com.ixigo.design.sdk.components.buttons.composable.ComposableSecondaryButton
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiShape

/**
 * A user interface element which has translucent colored background and  user can tap or click to perform
 * an action.
 *
 * User can also set text on IxiSecondaryButton along with start and end drawables
 *
 * To display a IxiSecondaryButton in an activity, add a IxiSecondaryButton to the activity's layout XML file:
 *
 *```
 * <com.ixigo.design.sdk.components.buttons.IxiSecondaryButton
 *  android:id="@+id/button_id"
 *  android:layout_width="match_parent"
 *  android:layout_height="wrap_content"
 *  android:drawableStart="@drawable/ic_call_24"
 *  android:drawableEnd="@drawable/ic_call_24"
 *  android:text="Secondary Button"/>
 * ```
 * To specify an action when the IxiSecondaryButton is pressed, set a click
 * listener on the IxiSecondaryButton object in the corresponding activity code:
 *
 *```
 * public class MyActivity extends Activity {
 *     protected void onCreate(Bundle savedInstanceState) {
 *         super.onCreate(savedInstanceState);
 *
 *         setContentView(R.layout.content_layout_id);
 *
 *         final IxiSecondaryButton button = findViewById(R.id.button_id);
 *         button.setStartImageDrawable(R.drawable.ic_call_24) // set start drawable
 *         button.setEndImageDrawable(R.drawable.ic_call_24) // set end drawable
 *         button.setOnClickListener(new View.OnClickListener() {
 *             public void onClick(View v) {
 *                 // Code here executes on main thread after user presses IxiSecondaryButton
 *             }
 *         });
 *     }
 * }
 *```
 *
 * The above snippet creates an instance of [android.view.View.OnClickListener] and wires
 * the listener to the [IxiSecondaryButton] using
 * ```setOnClickListener(View.OnClickListener)```.
 *
 * As a result, the system executes the code you write in ```onClick(View)``` after the
 * user presses the IxiSecondaryButton.
 *
 * @since 1.0
 */
class IxiSecondaryButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseButton(context, attrs, defStyleAttr) {


    public override fun setColor(color: IxiColor) {
        super.setColor(color)
    }

    public override fun setShape(shape: IxiShape) {
        super.setShape(shape)
    }

    public override fun setSize(size: ButtonSize) {
        super.setSize(size)
    }

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindow
        )
        with(state.value) {
            ComposableSecondaryButton(
                text,
                colors,
                shapes,
                sizes,
                isEnabled,
                preferredWidth,
                startDrawableState.value,
                endDrawableState.value,
                onClick
            )
        }
    }
}
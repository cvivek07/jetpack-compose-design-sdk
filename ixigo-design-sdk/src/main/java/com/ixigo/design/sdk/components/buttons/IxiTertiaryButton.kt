package com.ixigo.design.sdk.components.buttons

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.buttons.base.BaseButton
import com.ixigo.design.sdk.components.buttons.composable.ComposableTextButton
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize
import com.ixigo.design.sdk.components.styles.IxiColor

/**
 * A user interface element which has only text and no background and  user can tap or click to perform
 * an action.
 *
 * User can also set text on IxiTertiaryButton along with start and end drawable
 *
 * To display a IxiTertiaryButton in an activity, add a IxiTertiaryButton to the activity's layout XML file:
 *```
 * <com.ixigo.design.sdk.components.buttons.IxiTertiaryButton
 *  android:id="@+id/button_id"
 *  android:layout_width="match_parent"
 *  android:layout_height="wrap_content"
 *  android:drawableStart="@drawable/ic_call_24"
 *  android:drawableEnd="@drawable/ic_call_24"
 *  android:text="Outlined Button"/>
 * ```
 * To specify an action when the IxiTertiaryButton is pressed, set a click
 * listener on the IxiTertiaryButton object in the corresponding activity code:
 *```
 * public class MyActivity extends Activity {
 *     protected void onCreate(Bundle savedInstanceState) {
 *         super.onCreate(savedInstanceState);
 *
 *         setContentView(R.layout.content_layout_id);
 *
 *         final IxiTertiaryButton button = findViewById(R.id.button_id);
 *         button.setStartImageDrawable(R.drawable.ic_call_24) // set start drawable
 *         button.setEndImageDrawable(R.drawable.ic_call_24) // set end drawable
 *         button.setOnClickListener(new View.OnClickListener() {
 *             public void onClick(View v) {
 *                 // Code here executes on main thread after user presses IxiTertiaryButton
 *             }
 *         });
 *     }
 * }
 *```
 *
 * The above snippet creates an instance of [android.view.View.OnClickListener] and wires
 * the listener to the [IxiTertiaryButton] using
 * ```setOnClickListener(View.OnClickListener)```.
 *
 * As a result, the system executes the code you write in ```onClick(View)``` after the
 * user presses the IxiTertiaryButton.
 *
 *  @since 1.0
 */
class IxiTertiaryButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseButton(context, attrs, defStyleAttr) {


    public override fun setColor(color: IxiColor) {
        super.setColor(color)
    }

    public override fun setSize(size: ButtonSize) {
        super.setSize(size)
    }

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
             ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool
        )
        with(state.value) {
            ComposableTextButton(
                text,
                colors,
                sizes,
                preferredWidth,
                isEnabled,
                startDrawableState.value,
                endDrawableState.value,
                onClick
            )
        }
    }
}
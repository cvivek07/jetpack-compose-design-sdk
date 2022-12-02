package com.ixigo.design_sdk.components.progress_step.composables

import android.view.View
import android.widget.Button
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.ixigo.design.sdk.R
import com.ixigo.design_sdk.components.progress_step.base.ProgressStepData
import com.ixigo.design_sdk.components.styles.IxiFamily

@Composable
fun DrawNode(
    @DrawableRes iconRes: Int = R.drawable.ic_baseline_cancel_24,
    data: ProgressStepData,
    textStyle: TextStyle = com.ixigo.design_sdk.components.styles.Typography.Body.Large.regular,
    subTitleTextStyle: TextStyle = com.ixigo.design_sdk.components.styles.Typography.Body.Small.regular,
    actionView: View? = null,
    isLastItem: Boolean = false
) {
    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
        ConstraintLayout(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth()
        ) {
            val (icon, title, subtitle, line, view, spacer) = createRefs()
            val bottomBarrier = createBottomBarrier(title, subtitle, view, spacer)
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = "Image",
                modifier = Modifier.constrainAs(icon) {
                    start.linkTo(parent.start, margin = 15.dp)
                    top.linkTo(parent.top)
                },
//                colorFilter = if (drawableTint != 0) ColorFilter.tint(Color.Black) else null
            )

            if(!isLastItem) {
                Divider(
                    color = Color.Red,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .constrainAs(line) {
                            start.linkTo(icon.start)
                            end.linkTo(icon.end)
                            top.linkTo(icon.bottom)
                            bottom.linkTo(bottomBarrier)
                            height = Dimension.fillToConstraints
                        }
                )
            }

            Text(
                text = data.label,
                fontSize = textStyle.fontSize,
                fontWeight = textStyle.fontWeight,
                fontFamily = IxiFamily,
                letterSpacing = 0.sp,
                color = textStyle.color,
                textDecoration = textStyle.textDecoration,
                fontStyle = textStyle.fontStyle,
                lineHeight = textStyle.lineHeight,
                modifier = Modifier.constrainAs(title) {
                    start.linkTo(icon.end, margin = 10.dp)
                    top.linkTo(icon.top)
                }
            )

            Text(
                text = data.subText ?: "",
                fontSize = subTitleTextStyle.fontSize,
                fontWeight = subTitleTextStyle.fontWeight,
                fontFamily = IxiFamily,
                letterSpacing = 0.sp,
                color = subTitleTextStyle.color,
                textDecoration = subTitleTextStyle.textDecoration,
                fontStyle = subTitleTextStyle.fontStyle,
                lineHeight = subTitleTextStyle.lineHeight,
                modifier = Modifier.constrainAs(subtitle) {
                    start.linkTo(title.start)
                    end.linkTo(parent.end)
                    top.linkTo(title.bottom)
                    width = Dimension.fillToConstraints
                }
            )

            if (actionView != null) {
                AndroidView(factory = { actionView },
                    modifier = Modifier.constrainAs(view) {
                        start.linkTo(title.start)
                        end.linkTo(parent.end)
                        top.linkTo(subtitle.bottom)
                        width = Dimension.wrapContent
                    })
            }

            Spacer(modifier = Modifier
                .height(20.dp)
                .constrainAs(spacer) {
                    top.linkTo(view.bottom)
                    top.linkTo(subtitle.bottom)
                })


        }
    }
}


@Composable
fun DrawSteps(steps: List<ProgressStepData>) {
    Column() {
        steps.forEachIndexed { index,stepData ->
            DrawNode(data = stepData, isLastItem = index == steps.size-1)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    val steps = listOf(
        ProgressStepData(
            "Label 1",
            "A lot of sub text with some jucy content and some cowboy shit with some of the other snacks today for all of us"
        ),
        ProgressStepData(
            "Label 2",
            "A lot of sub text with some "
        ),

        ProgressStepData(
            "Label 3",
            "A lot of sub text with some jucy content and some cowboy shit with some of the other snacks today for all of us jucy content and some cowboy shit with some of the other snacks today for all of us jucy content and some cowboy shit with some of the other snacks today for all of us"
        ),
        ProgressStepData(
            "Label 4",
            "A lot of sub text with some jucy content and some cowboy shit with some of the other snacks today for all of us"
        ),
        ProgressStepData(
            "Label 5",
            "A lot of sub text with some jucy content and some cowboy shit with some of the other snacks today for all of us"
        ),

        ProgressStepData(
            "Label 6",
            "A lot of sub text with some jucy "
        ),
    )

    DrawSteps(steps = steps)
//    DrawNode(
//        iconRes = R.drawable.ic_baseline_cancel_24,
//        data = ProgressStepData(
//            "Label jskahlkshak",
//            "A lot of sub text with some jucy content and some cowboy shit with some of the other snacks today for all of us"
//        ),
//        textStyle = com.ixigo.design_sdk.components.styles.Typography.Body.Large.regular,
//        subTitleTextStyle = com.ixigo.design_sdk.components.styles.Typography.Body.Small.regular,
////        actionView = Button(LocalContext.current).apply {
////            setText("Action")
////        }
//    )
}
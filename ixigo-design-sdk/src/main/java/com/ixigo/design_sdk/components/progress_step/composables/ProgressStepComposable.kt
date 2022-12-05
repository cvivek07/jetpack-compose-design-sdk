package com.ixigo.design_sdk.components.progress_step.composables

import android.view.View
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.ixigo.design_sdk.components.progress_step.base.ProgressState
import com.ixigo.design_sdk.components.progress_step.base.ProgressStepData
import com.ixigo.design_sdk.components.progress_step.base.ProgressStepSize
import com.ixigo.design_sdk.components.progress_step.base.SelectionIndicator
import com.ixigo.design_sdk.components.styles.IxiFamily
import com.ixigo.design.sdk.R
import com.ixigo.design_sdk.components.styles.Typography

@Composable
fun DrawNode(
    data: ProgressStepData,

    actionView: View? = null,
    isLastItem: Boolean = false,
    progressStepSize: ProgressStepSize,
    progressState: ProgressState = ProgressState.Active,
    selectionIndicator: SelectionIndicator = SelectionIndicator.NUMBER,
    index: Int,
    lineColor: Int
) {

    val textStyle: TextStyle = if (progressState == ProgressState.Active) {
        Typography.Body.Large.medium
    } else {
        Typography.Body.Large.regular
    }
    val subTitleTextStyle: TextStyle = Typography.Body.Small.regular

    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val (icon, title, subtitle, line, view, spacer) = createRefs()
            val bottomBarrier = createBottomBarrier(title, subtitle, view, spacer)
            if (selectionIndicator == SelectionIndicator.NUMBER) {
                if (progressState == ProgressState.Completed) {
                    ProgressStepNumberSuccess(
                        state = progressState,
                        progressSize = progressStepSize,
                        text = index,
                        modifier = Modifier.constrainAs(icon) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        }
                    )
                } else {
                    ProgressStepNumber(
                        state = progressState,
                        modifier = Modifier.constrainAs(icon) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        },
                        text = index,
                        progressSize = progressStepSize
                    )
                }
            } else {
                if (progressState == ProgressState.Completed) {
                    ProgressStepIconSuccess(
                        state = progressState,
                        progressSize = progressStepSize,
                        modifier = Modifier.constrainAs(icon) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        }
                    )
                } else {
                    ProgressStepIcon(
                        state = progressState,
                        modifier = Modifier.constrainAs(icon) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        },
                        progressSize = progressStepSize
                    )
                }
            }

            if (!isLastItem) {
                Divider(
                    color = colorResource(id = lineColor),
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
fun DrawSteps(
    steps: List<ProgressStepData>,
    progressStepSize: ProgressStepSize = ProgressStepSize.Large,
    selectionIndicator: SelectionIndicator = SelectionIndicator.NUMBER,
    currentItem: Int = 0,
    currentProgressState: ProgressState? = null
) {

    Column {
        steps.forEachIndexed { index, stepData ->

            val progressStateValue = if (index < currentItem) {
                ProgressState.Completed
            } else if (index == currentItem) {
                currentProgressState ?: ProgressState.Active
            } else {
                ProgressState.InActive
            }
            val lineColor = if (index < currentItem) {
                R.color.g500
            } else {
                R.color.n300
            }
            DrawNode(
                data = stepData,
                isLastItem = index == steps.size - 1,
                index = index,
                progressStepSize = progressStepSize,
                progressState = progressStateValue,
                selectionIndicator = selectionIndicator,
                lineColor = lineColor
            )
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
}
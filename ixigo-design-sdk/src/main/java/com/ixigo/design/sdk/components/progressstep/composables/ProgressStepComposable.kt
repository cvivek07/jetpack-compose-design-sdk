package com.ixigo.design_sdk.components.progress_step.composables

import android.view.View
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.progressstep.base.*
import com.ixigo.design.sdk.components.progressstep.composables.*
import com.ixigo.design.sdk.components.styles.IxiFamily
import com.ixigo.design.sdk.components.styles.IxiTypography
import kotlinx.coroutines.CoroutineScope

@Composable
fun DrawVerticalNode(
    data: ProgressStepData,
    actionView: View? = null,
    isLastItem: Boolean = false,
    progressStepIconSize: ProgressStepIconSize,
    progressState: ProgressState = ProgressState.Active,
    selectionIndicator: SelectionIndicator = SelectionIndicator.NUMBER,
    index: Int,
    lineColor: Int
) {

    val textStyle: TextStyle = if (progressState == ProgressState.Active) {
        IxiTypography.Body.Large.medium
    } else {
        IxiTypography.Body.Large.regular
    }
    val subTitleTextStyle: TextStyle = IxiTypography.Body.Small.regular

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
                        progressSize = progressStepIconSize,
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
                        progressSize = progressStepIconSize
                    )
                }
            } else {
                if (progressState == ProgressState.Completed) {
                    ProgressStepIconSuccess(
                        state = progressState,
                        progressSize = progressStepIconSize,
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
                        iconSize = progressStepIconSize
                    )
                }
            }

            if (!isLastItem) {
                Divider(
                    color = colorResource(id = lineColor),
                    modifier = Modifier
                        .height(IntrinsicSize.Max)
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
                modifier = Modifier
                    .heightIn(max = 200.dp)
                    .constrainAs(subtitle) {
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
fun DrawHorizontalNode(
    data: ProgressStepData,
    actionView: View? = null,
    isLastItem: Boolean = false,
    progressStepIconSize: ProgressStepIconSize,
    progressState: ProgressState = ProgressState.Active,
    selectionIndicator: SelectionIndicator = SelectionIndicator.NUMBER,
    index: Int,
    lineColor: Int
) {
    val textStyle: TextStyle = if (progressState == ProgressState.Active) {
        IxiTypography.Body.Large.medium
    } else {
        IxiTypography.Body.Large.regular
    }
    val subTitleTextStyle: TextStyle = IxiTypography.Body.Small.regular

    BoxWithConstraints(modifier = Modifier.wrapContentWidth()) {
        ConstraintLayout(
            modifier = Modifier.wrapContentWidth()
        ) {
            val (icon, title, subtitle, line, view, spacer) = createRefs()
            val endBarrier = createEndBarrier(title, subtitle, view, spacer)
            if (selectionIndicator == SelectionIndicator.NUMBER) {
                if (progressState == ProgressState.Completed) {
                    ProgressStepNumberSuccess(
                        state = progressState,
                        progressSize = progressStepIconSize,
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
                        progressSize = progressStepIconSize
                    )
                }
            } else {
                if (progressState == ProgressState.Completed) {
                    ProgressStepIconSuccess(
                        state = progressState,
                        progressSize = progressStepIconSize,
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
                        iconSize = progressStepIconSize
                    )
                }
            }

            if (!isLastItem) {
                Divider(
                    color = colorResource(id = lineColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .constrainAs(line) {
                            start.linkTo(icon.end)
                            top.linkTo(icon.top)
                            bottom.linkTo(icon.bottom)
                            end.linkTo(endBarrier)
                            width = Dimension.fillToConstraints
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
                    start.linkTo(icon.start, margin = 10.dp)
                    top.linkTo(icon.bottom)
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
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .widthIn(max = 200.dp)
                    .constrainAs(subtitle) {
                        start.linkTo(title.start)
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
fun DrawHorizontalInlineNode(
    data: ProgressStepData,
    isLastItem: Boolean = false,
    progressStepIconSize: ProgressStepIconSize,
    progressState: ProgressState = ProgressState.Active,
    selectionIndicator: SelectionIndicator = SelectionIndicator.NUMBER,
    index: Int,
    lineColor: Int,
    mode: ProgressStepMode = ProgressStepMode.Dark
) {
    val textStyle: TextStyle = if (progressState == ProgressState.Active) {
        IxiTypography.Body.Large.medium
    } else {
        IxiTypography.Body.Large.regular
    }

    val textColor  = if(mode == ProgressStepMode.Dark) {
        R.color.n0
    } else {
        if(progressState == ProgressState.Active) {
            R.color.b500
        } else {
            R.color.n600
        }
    }
    BoxWithConstraints(modifier = Modifier.wrapContentWidth()) {
        ConstraintLayout(
            modifier = Modifier.wrapContentWidth()
        ) {
            val (icon, title, subtitle, line, view, spacer) = createRefs()
            val endBarrier = createEndBarrier(title, subtitle, view, spacer)

            if (selectionIndicator == SelectionIndicator.NUMBER) {
                when (progressState) {
                    ProgressState.Completed -> {
                        ProgressStepInlineSuccessIcon(
                            mode = mode,
                            progressSize = progressStepIconSize,
                            modifier = Modifier.constrainAs(icon) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                            }
                        )
                    }
                    ProgressState.Active -> {
                        ProgressStepInlineActiveIcon(
                            mode = mode,
                            progressSize = progressStepIconSize,
                            modifier = Modifier.constrainAs(icon) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                            }, text = index.toString()
                        )
                    }
                    else -> {
                        ProgressStepInlineInactiveIcon(
                            mode = mode,
                            progressSize = progressStepIconSize,
                            modifier = Modifier.constrainAs(icon) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                            }, text = index.toString()
                        )
                    }
                }
            } else {
                when (progressState) {
                    ProgressState.Completed -> {
                        ProgressStepInlineSuccessIcon(
                            mode = mode,
                            progressSize = progressStepIconSize,
                            modifier = Modifier.constrainAs(icon) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                            }
                        )
                    }
                    ProgressState.Active -> {
                        ProgressStepInlineActiveIcon(
                            mode = mode,
                            progressSize = progressStepIconSize,
                            modifier = Modifier.constrainAs(icon) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                            }
                        )
                    }
                    else -> {
                        ProgressStepInlineInactiveIcon(
                            mode = mode,
                            progressSize = progressStepIconSize,
                            modifier = Modifier.constrainAs(icon) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                            }
                        )
                    }
                }
            }

            if (!isLastItem) {
                Divider(
                    color = colorResource(id = lineColor),
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .width(20.dp)
                        .height(1.dp)
                        .constrainAs(line) {
                            start.linkTo(title.end)
                            top.linkTo(title.top)
                            bottom.linkTo(title.bottom)
                        }
                )
            }

            Text(
                text = data.label,
                fontSize = textStyle.fontSize,
                fontWeight = textStyle.fontWeight,
                fontFamily = IxiFamily,
                letterSpacing = 0.sp,
                color = colorResource(id = textColor),
                textDecoration = textStyle.textDecoration,
                fontStyle = textStyle.fontStyle,
                lineHeight = textStyle.lineHeight,
                modifier = Modifier.constrainAs(title) {
                    start.linkTo(icon.end, margin = 10.dp)
                    top.linkTo(icon.top)
                    bottom.linkTo(icon.bottom)
                }
            )
        }
    }
}

/**
 * Draw the Vertical Progress Steps. Scrolling behaviour will only work if the VerticalProgressStep
 * is either not a child of any vertical scrolling Component or the items are so large that height
 * of this VerticalProgressStep is greater than 1200dp
 */
@Composable
fun DrawVerticalSteps(
    steps: List<ProgressStepData>,
    progressStepIconSize: ProgressStepIconSize = ProgressStepIconSize.Large,
    selectionIndicator: SelectionIndicator = SelectionIndicator.NUMBER,
    currentItem: Int = 0,
    currentProgressState: ProgressState? = null,
    scrollToPosition: ((LazyListState, CoroutineScope) -> Unit)? = null
) {
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    LazyColumn(state = listState, modifier = Modifier.heightIn(max = 1200.dp)) {
        items(steps.size) { index ->
            val stepData = steps[index]
            val progressStateValue = getProgressState(index, currentItem, currentProgressState)
            val lineColor = getLineColor(index, currentItem)

            DrawVerticalNode(
                data = stepData,
                isLastItem = index == steps.size - 1,
                index = index,
                progressStepIconSize = progressStepIconSize,
                progressState = progressStateValue,
                selectionIndicator = selectionIndicator,
                lineColor = lineColor
            )
        }
        scrollToPosition?.invoke(listState, coroutineScope)
    }

}

@Composable
fun DrawHorizontalSteps(
    steps: List<ProgressStepData>,
    progressStepIconSize: ProgressStepIconSize = ProgressStepIconSize.Large,
    selectionIndicator: SelectionIndicator = SelectionIndicator.NUMBER,
    currentItem: Int = 0,
    currentProgressState: ProgressState? = null,
    scrollToPosition: ((LazyListState, CoroutineScope) -> Unit)? = null
) {
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    LazyRow(state = listState) {
        items(steps.size) { index ->
            val stepData = steps[index]
            val progressStateValue = getProgressState(index, currentItem, currentProgressState)
            val lineColor = getLineColor(index, currentItem)

            DrawHorizontalNode(
                data = stepData,
                isLastItem = index == steps.size - 1,
                index = index,
                progressStepIconSize = progressStepIconSize,
                progressState = progressStateValue,
                selectionIndicator = selectionIndicator,
                lineColor = lineColor
            )
        }
        scrollToPosition?.invoke(listState, coroutineScope)
    }

}

@Composable
fun DrawHorizontalInlineSteps(
    steps: List<ProgressStepData>,
    progressStepIconSize: ProgressStepIconSize = ProgressStepIconSize.Large,
    selectionIndicator: SelectionIndicator = SelectionIndicator.NUMBER,
    currentItem: Int = 0,
    currentProgressState: ProgressState? = null,
    mode: ProgressStepMode = ProgressStepMode.Dark,
    scrollToPosition: ((LazyListState, CoroutineScope) -> Unit)? = null
) {
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    LazyRow(state = listState) {
        items(steps.size) { index ->
            val stepData = steps[index]
            val progressStateValue = getProgressState(index, currentItem, currentProgressState)
            val lineColor = if(mode == ProgressStepMode.Dark) {
                R.color.n100
            } else {
                R.color.n300
            }

            DrawHorizontalInlineNode(
                data = stepData,
                isLastItem = index == steps.size - 1,
                index = index,
                progressStepIconSize = progressStepIconSize,
                progressState = progressStateValue,
                selectionIndicator = selectionIndicator,
                lineColor = lineColor,
                mode = mode
            )
        }
        scrollToPosition?.invoke(listState, coroutineScope)
    }

}

@Composable
private fun getLineColor(index: Int, currentItem: Int) = if (index < currentItem) {
    R.color.g500
} else {
    R.color.n300
}

private fun getProgressState(
    index: Int,
    currentItem: Int,
    currentProgressState: ProgressState?
) = if (index < currentItem) {
    ProgressState.Completed
} else if (index == currentItem) {
    currentProgressState ?: ProgressState.Active
} else {
    ProgressState.InActive
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

    DrawHorizontalInlineSteps(steps = steps, mode = ProgressStepMode.Light)
}
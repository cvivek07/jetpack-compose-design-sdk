package com.ixigo.design_sdk.components.progress_step.composables

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design_sdk.components.progress_step.base.ProgressState

private val outerRadius = 10.dp
private val middleRadius = 7.dp
private val innerRadius = 4.dp

@Composable
fun ProgressStepIcon(state: ProgressState, modifier: Modifier = Modifier) {
    val outerColor = colorResource(id = getOuterColor(state))
    val innerColor = colorResource(id = getInnerColor(state))
    Canvas(
        modifier = modifier
            .size(30.dp)
            .background(Color.Transparent)
    ) {
        drawCircle(
            color = outerColor,
            radius = outerRadius.toPx(),
            style = Stroke(width = 6.dp.toPx())
        )
        drawCircle(
            color = innerColor,
            radius = middleRadius.toPx(),
            style = Stroke(width = 1.dp.toPx())
        )
        drawCircle(
            color = innerColor,
            radius = innerRadius.toPx(),
        )
    }
}

@Composable
fun ProgressStepNumber(state: ProgressState, text: Int, modifier: Modifier = Modifier) {
    val outerColor = colorResource(id = getOuterColor(state))
    val innerColor = colorResource(id = getInnerColor(state))
    val typography = com.ixigo.design_sdk.components.styles.Typography.Body.XSmall.regular


    Canvas(
        modifier = modifier
            .size(30.dp)
            .background(Color.Transparent)

    ) {
        drawCircle(
            color = outerColor,
            radius = outerRadius.toPx(),
            style = Stroke(width = 6.dp.toPx())
        )
        drawCircle(
            color = innerColor,
            radius = middleRadius.toPx(),
            style = Stroke(width = 1.dp.toPx()),
        )

        drawContext.canvas.nativeCanvas.apply {
            drawText(
                text.toString(),
                size.width / 2,
                size.height/2 + ( innerRadius.toPx()),
                Paint().apply {
                    textSize = typography.fontSize.toPx()
                    color = getInnerColor(state)
                    textAlign = Paint.Align.CENTER
                    isAntiAlias = true
                }
            )
        }
    }

}

fun getOuterColor(state: ProgressState) = when (state) {
    ProgressState.Active -> {
        R.color.g50
    }
    ProgressState.Completed -> {
        R.color.g50
    }
    ProgressState.Delay -> {
        R.color.y50
    }
    ProgressState.Error -> {
        R.color.r50
    }
    ProgressState.InActive -> {
        R.color.n0
    }
}

fun getInnerColor(state: ProgressState) = when (state) {
    ProgressState.Active -> {
        R.color.g500
    }
    ProgressState.Completed -> {
        R.color.g500
    }
    ProgressState.Delay -> {
        R.color.y500
    }
    ProgressState.Error -> {
        R.color.r500
    }
    ProgressState.InActive -> {
        R.color.n300
    }
}

@Composable
@Preview
fun preview() {
    ProgressStepNumber(ProgressState.Completed, 1)
}
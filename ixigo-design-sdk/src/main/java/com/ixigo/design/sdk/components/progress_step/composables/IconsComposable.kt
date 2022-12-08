package com.ixigo.design_sdk.components.progress_step.composables

import android.R.attr
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.ixigo.design.sdk.R
import com.ixigo.design_sdk.components.progress_step.base.ProgressState
import com.ixigo.design_sdk.components.progress_step.base.ProgressStepMode
import com.ixigo.design_sdk.components.progress_step.base.ProgressStepSize
import com.ixigo.design_sdk.components.progress_step.base.SelectionIndicator
import com.ixigo.design_sdk.components.styles.Colors


private val outerRadius = 10.dp
private val middleRadius = 9.dp
private val innerRadius = 5.dp
private val outerStroke = 5.dp

@Composable
fun ProgressStepIcon(
    state: ProgressState,
    modifier: Modifier = Modifier,
    progressSize: ProgressStepSize,
) {
    val outerColor = colorResource(id = getOuterColor(state))
    val innerColor = colorResource(id = getInnerColor(state))
    Canvas(
        modifier = modifier
            .size(progressSize.size)
            .background(Color.Transparent)
    ) {
        drawCircle(
            color = outerColor,
            radius = outerRadius.toPx(),
            style = Stroke(width = outerStroke.toPx())
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
fun ProgressStepIconSuccess(
    state: ProgressState,
    progressSize: ProgressStepSize,
    modifier: Modifier = Modifier,
) {
    val innerColor = colorResource(id = getInnerColor(state))
    val tickColor = colorResource(id = R.color.n0)
    Canvas(
        modifier = modifier
            .size(progressSize.size)
    ) {
        drawCircle(
            color = innerColor,
            radius = outerRadius.toPx(),
        )
        drawTick(tickColor)
    }
}

@Composable
fun ProgressStepNumber(
    state: ProgressState,
    progressSize: ProgressStepSize,
    text: Int,
    modifier: Modifier = Modifier
) {
    val outerColor = colorResource(id = getOuterColor(state))
    val innerColorRes = getInnerColor(state)
    val innerColor = colorResource(id = innerColorRes)
    val textColor = ContextCompat.getColor(LocalContext.current, innerColorRes)
    Canvas(
        modifier = modifier
            .size(size = progressSize.size)
    ) {
        drawCircle(
            color = outerColor,
            radius = outerRadius.toPx(),
            style = Stroke(width = outerStroke.toPx())
        )
        drawCircle(
            color = innerColor,
            radius = middleRadius.toPx(),
            style = Stroke(width = 1.dp.toPx()),
        )
        drawText(text.toString(), progressSize, textColor)
    }

}

@Composable
fun ProgressStepNumberSuccess(
    state: ProgressState,
    progressSize: ProgressStepSize,
    text: Int,
    modifier: Modifier = Modifier
) {
    val innerColorRes = getInnerColor(state)
    val innerColor = colorResource(id = innerColorRes)
    val textColor = ContextCompat.getColor(LocalContext.current, R.color.n0)
    Canvas(
        modifier = modifier
            .size(size = progressSize.size)
    ) {

        drawCircle(
            color = innerColor,
            radius = outerRadius.toPx(),
        )

        drawText(text.toString(), progressSize, textColor)

    }

}


@Composable
fun ProgressStepInlineSuccessIcon(
    mode: ProgressStepMode,
    progressSize: ProgressStepSize,
    modifier: Modifier = Modifier,
) {
    val bgColor = if (mode == ProgressStepMode.Dark) {
        colorResource(id = R.color.b300)
    } else {
        colorResource(id = R.color.b500)
    }

    val tickColor = colorResource(id = R.color.n0)

    Canvas(
        modifier = modifier
            .size(progressSize.size)
    ) {
        drawCircle(
            color = bgColor,
            radius = progressSize.size.toPx() / 2,
        )
        drawTick(tickColor)
    }
}


@Composable
fun ProgressStepInlineActiveIcon(
    mode: ProgressStepMode,
    progressSize: ProgressStepSize,
    modifier: Modifier = Modifier,
    text: String? = null
) {
    val bgColor = if (mode == ProgressStepMode.Dark) {
        colorResource(id = R.color.n0)
    } else {
        colorResource(id = R.color.b500)
    }

    val tickColor = colorResource(id = R.color.b500)
    val textColor = ContextCompat.getColor(LocalContext.current, R.color.b500)

    val stroke = 2.dp
    val radius = (progressSize.size / 2) - stroke
    Canvas(
        modifier = modifier
            .size(progressSize.size)
    ) {
        drawCircle(
            color = bgColor,
            radius = radius.toPx(),
            style = if (mode == ProgressStepMode.Dark) {
                Fill
            } else {
                Stroke(width = stroke.toPx())
            }
        )
        if (!text.isNullOrBlank()) {
            drawText(text, progressSize, textColor)
        } else {
            drawTick(tickColor)
        }

    }
}

@Composable
fun ProgressStepInlineInactiveIcon(
    mode: ProgressStepMode,
    progressSize: ProgressStepSize,
    modifier: Modifier = Modifier,
    text: String? = null
) {
    val bgColor = if (mode == ProgressStepMode.Dark) {
        colorResource(id = R.color.n0)
    } else {
        colorResource(id = R.color.n300)
    }
    val tickColor = if (mode == ProgressStepMode.Dark) {
        colorResource(id = R.color.n0)
    } else {
        colorResource(id = R.color.n600)
    }
    val textColor = if (mode == ProgressStepMode.Dark) {
        ContextCompat.getColor(LocalContext.current, R.color.n0)
    } else {
        ContextCompat.getColor(LocalContext.current, R.color.n600)
    }
    val stroke = 1.dp
    val radius = (progressSize.size / 2) - stroke
    Canvas(
        modifier = modifier.size(progressSize.size)
    ) {
        drawCircle(
            color = bgColor,
            radius = radius.toPx(),
            style = Stroke(width = stroke.toPx())
        )
        if (!text.isNullOrBlank()) {
            drawText(text, progressSize, textColor)
        } else {
            drawTick(tickColor)
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

private fun DrawScope.drawTick(tickColor: Color) {
    drawLine(
        strokeWidth = 1.dp.toPx(),
        color = tickColor,
        start = Offset(x = 10.dp.toPx(), y = 14.dp.toPx()),
        end = Offset(x = 13.dp.toPx(), y = 18.dp.toPx())
    )
    drawLine(
        strokeWidth = 1.dp.toPx(),
        color = tickColor,
        start = Offset(x = 13.dp.toPx(), y = 18.dp.toPx()),
        end = Offset(x = 20.dp.toPx(), y = 12.dp.toPx())
    )
}


private fun DrawScope.drawText(
    text: String,
    progressSize: ProgressStepSize,
    textColor: Int
) {
    drawContext.canvas.nativeCanvas.apply {
        drawText(
            text,
            size.width / 2,
            size.height / 2 + (progressSize.textStyle.fontSize.toPx() / 3),
            Paint().apply {
                textSize = progressSize.textStyle.fontSize.toPx()
                color = textColor
                textAlign = Paint.Align.CENTER
                isAntiAlias = true
            }
        )
    }
}

@Composable
@Preview(showSystemUi = true, backgroundColor = 0x989a82)
fun preview() {
    Column() {
        ProgressStepNumberSuccess(
            state = ProgressState.Completed,
            progressSize = ProgressStepSize.Large,
            text = 1
        )
        Spacer(modifier = Modifier.height(10.dp))
        ProgressStepIconSuccess(
            ProgressState.Completed,
            ProgressStepSize.Large
        )

        Spacer(modifier = Modifier.height(10.dp))
        ProgressStepInlineSuccessIcon(
            ProgressStepMode.Dark,
            ProgressStepSize.Large,
            Modifier
        )
        Spacer(modifier = Modifier.height(10.dp))
        ProgressStepInlineInactiveIcon(
            ProgressStepMode.Light,
            ProgressStepSize.Large,
            Modifier, 1.toString()
        )

        Spacer(modifier = Modifier.height(10.dp))
        ProgressStepInlineActiveIcon(
            ProgressStepMode.Light,
            ProgressStepSize.Large,
            Modifier
        )
    }
}


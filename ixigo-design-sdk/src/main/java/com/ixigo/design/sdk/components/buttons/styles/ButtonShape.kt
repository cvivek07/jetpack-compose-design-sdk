package com.ixigo.design.sdk.components.buttons.styles

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

sealed class ButtonShape(val shape: Shape) {
    object TrailingShape : ButtonShape(TrailingShape())
    object LeadingShape : ButtonShape(LeadingShape())
    object BottomShape : ButtonShape(BottomShape())
    object RegularShape : ButtonShape(RoundedCornerShape(10.dp))
}


private class TrailingShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val radius = if (size.width > size.height) size.width / 2f else size.height / 2f
        val shapeHeight = size.height
        val shapeWidth = size.width - radius

        val rect = Rect(
            left = size.width - size.height,
            top = 0f,
            right = size.width,
            bottom = shapeHeight
        )
        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(shapeWidth, 0f)
            arcTo(
                rect = rect,
                startAngleDegrees = -90.0f,
                sweepAngleDegrees = 180.0f,
                forceMoveTo = false
            )
            lineTo(0f, shapeHeight)
        }
        return Outline.Generic(path)
    }
}

private class LeadingShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val radius = if (size.width > size.height) size.width / 2f else size.height / 2f
        val shapeHeight = size.height
        val shapeWidth = size.width - radius

        val rect = Rect(
            left = 0f,
            top = 0f,
            right = shapeHeight,
            bottom = shapeHeight
        )
        val path = Path().apply {
            moveTo(size.width, 0f)
            lineTo(shapeWidth, 0f)
            arcTo(
                rect = rect,
                startAngleDegrees = -90.0f,
                sweepAngleDegrees = -180.0f,
                forceMoveTo = false
            )
            lineTo(size.width, shapeHeight)
        }
        return Outline.Generic(path)
    }
}

private class BottomShape(private val radius: Dp = 8.dp) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val radiusValue = with(density) { radius.toPx() }
        val diameter = 2 * radiusValue
        val shapeHeight = size.height - diameter
        val shapeWidth = size.width - diameter

        val bottomStartRect = Rect(
            left = 0f,
            top = shapeHeight,
            right = diameter,
            bottom = size.height
        )
        val bottomEndRect = Rect(
            left = shapeWidth,
            top = shapeHeight,
            right = size.width,
            bottom = size.height
        )
        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(0f, shapeHeight)
            arcTo(
                rect = bottomStartRect,
                startAngleDegrees = -180.0f,
                sweepAngleDegrees = -90.0f,
                forceMoveTo = false
            )
            lineTo(shapeWidth, size.height)
            arcTo(
                rect = bottomEndRect,
                startAngleDegrees = -270.0f,
                sweepAngleDegrees = -90.0f,
                forceMoveTo = false
            )
            lineTo(size.width, 0F)
        }

        return Outline.Generic(path)
    }
}
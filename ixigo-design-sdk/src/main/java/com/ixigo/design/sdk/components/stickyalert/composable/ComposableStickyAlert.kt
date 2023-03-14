package com.ixigo.design.sdk.components.stickyalert.composable

import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.ixigo.design.sdk.components.buttons.composable.ComposableOutlinedButton
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize
import com.ixigo.design.sdk.components.imageutils.ImageData
import com.ixigo.design.sdk.components.imageutils.getPainterForImage
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiShape
import com.ixigo.design.sdk.components.styles.IxiStickyAlertColor
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

private val iconDefaultSize = 20.dp

@Composable
fun ComposableStickyAlert(
    text: String,
    leftIcon: ImageData? = null,
    rightIcon: ImageData? = null,
    leftButtonText: String? = "",
    leftButtonClickListener: () -> Unit = {},
    rightButtonText: String? = "",
    rightButtonClickListener: () -> Unit = {},
    ixiColor: IxiColor = IxiStickyAlertColor.Success,
    @ColorRes buttonColor: Int? = null,
    elevation:Int? = null,
    spaced:Boolean = true
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 4.dp, end = 4.dp, start = 2.dp)
        .then(if(elevation!=null) Modifier.shadow(elevation*1.dp) else Modifier )
        .background(color = colorResource(id = ixiColor.bgColor)),
    ){
        Row(modifier = Modifier.align(Alignment.Center), verticalAlignment = Alignment.CenterVertically) {
            leftIcon?.let {
                Icon(leftIcon, modifier = Modifier.padding(start = 18.dp))
            }
            Spacer(modifier = Modifier.width(10.dp))
            TypographyText(
                text = text,
                textStyle = IxiTypography.Body.Small.regular,
                modifier = Modifier
                    .padding(vertical = 15.dp).then(if(spaced) Modifier.weight(1.4f) else Modifier),
                color = colorResource(
                    id = ixiColor.textColor
                )
            )
            Spacer(modifier = Modifier.width(5.dp))
            Buttons(
                modifier = if(spaced) Modifier.weight(1.1f) else Modifier,
                leftButtonText = leftButtonText,
                leftButtonClickListener = leftButtonClickListener,
                rightButtonText = rightButtonText,
                rightButtonClickListener = rightButtonClickListener,
                ixicolor = ixiColor,
                buttonColor = buttonColor,
                spaced = spaced
            )
            Spacer(modifier = Modifier.width(10.dp))
            rightIcon?.let {
                Icon(icon = rightIcon, modifier = Modifier.padding(end = 16.dp))
            }
        }
    }
}

@Composable fun Buttons(
    modifier: Modifier = Modifier,
    leftButtonText: String? = "",
    leftButtonClickListener: () -> Unit = {},
    rightButtonText: String? = "",
    rightButtonClickListener: () -> Unit = {},
    ixicolor: IxiColor,
    @ColorRes buttonColor:Int? = null,
    spaced: Boolean = false
){
    var buttonIxiColor:IxiColor = IxiColor.Extra(bg = ixicolor.textColor, pressed = ixicolor.textColor, text = ixicolor.textColor)
    buttonColor?.let {
        buttonIxiColor = IxiColor.Extra(buttonColor, buttonColor, buttonColor)
    }
    Box(modifier = modifier.height(IntrinsicSize.Min)){
        Row(modifier = Modifier.align(Alignment.Center), verticalAlignment = Alignment.CenterVertically) {
            if(leftButtonText!=null && leftButtonText.isNotEmpty()) {
                Box(modifier = if(spaced) Modifier.weight(1f) else Modifier){
                    ComposableOutlinedButton(
                        text = leftButtonText,
                        color = buttonIxiColor,
                        shape = IxiShape.RegularShape,
                        size = ButtonSize.Small,
                        width = -2,
                        onClick = leftButtonClickListener
                    )
                }
            }
            if(rightButtonText!=null && rightButtonText.isNotEmpty() && leftButtonText!=null&& leftButtonText.isNotEmpty()) {
                Spacer(modifier = Modifier.width(5.dp))
            }
            if(rightButtonText!=null && rightButtonText.isNotEmpty()) {
                Box(modifier = if(spaced) Modifier.weight(1f) else Modifier) {
                    ComposableOutlinedButton(
                        text = rightButtonText,
                        color = buttonIxiColor,
                        shape = IxiShape.RegularShape,
                        size = ButtonSize.Small,
                        width = -2,
                        onClick = rightButtonClickListener
                    )
                }
            }
        }
    }
}

@Composable fun Icon(icon:ImageData, modifier: Modifier=Modifier){
    icon.getPainterForImage()?.let {
        androidx.compose.material.Icon(
            modifier = modifier
                .width(icon.width ?: iconDefaultSize)
                .height(icon.height ?: iconDefaultSize),
            painter = it,
            contentDescription = ""
        )
    }
}

@Preview
@Composable
fun PreviewComposable(){
    ComposableStickyAlert(
        text = "Feedback message for user action",
        rightButtonText = "Test",
        leftButtonText = "Test",
        spaced = false
    )
//    ComposableOutlinedButton(
//        text = "rightButtonText",
//        color = IxiColor.Orange,
//        shape = IxiShape.RegularShape,
//        size = ButtonSize.Small,
//        width = -2,
//        onClick = {}
//    )
}
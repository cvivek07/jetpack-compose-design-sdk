package com.ixigo.design.sdk.components.inlinealert.composable

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.buttons.composable.ComposableTextButton
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

@Composable
fun ComposableInlineAlert(
    @DrawableRes logo: Int? = null,
    heading:String? = null,
    text:String,
    @DrawableRes actionIcon:Int? = null,
    leftButtonText:String? = null,
    leftButtonClickListener:() -> Unit = {},
    rightButtonText:String? = null,
    rightButtonClickListener:() -> Unit = {},
    onRightIconClickListener: (()->Unit)? = null,
    ixiColor: IxiColor = IxiColor.Extra(bg = R.color.b50, text = R.color.b500, pressed = R.color.b400),
    headingAlignment: TextAlign = TextAlign.Start,
    textAlignment: TextAlign = TextAlign.Start,
    buttonColor:Int? = null
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = colorResource(id = ixiColor.bgColor),
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Row(verticalAlignment = Alignment.Top, modifier = Modifier.padding(10.dp)) {
            Box(modifier = Modifier.weight(3f)){
                Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Center) {
                    logo?.let {
                        Image(modifier = Modifier.size(40.dp),painter = painterResource(id = logo), contentDescription = null)
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                    InlineAlertContent(
                        heading = heading,
                        text = text,
                        leftButtonText = leftButtonText,
                        leftButtonClickListener = leftButtonClickListener,
                        rightButtonText = rightButtonText,
                        rightButtonClickListener = rightButtonClickListener,
                        ixiColor = ixiColor,
                        headingAlignment = headingAlignment,
                        textAlignment = textAlignment,
                        buttonColor = buttonColor
                    )
                }
            }
            actionIcon?.let {
            Box(modifier = Modifier.weight(0.5f)) {
                    Icon(modifier = Modifier
                        .size(15.dp)
                        .align(Alignment.TopEnd)
                        .clickable {
                            onRightIconClickListener?.invoke()
                        }, painter = painterResource(id = actionIcon), contentDescription = null)
                }
            }
        }
    }


}

@Composable
fun InlineAlertContent(
    heading: String? = null,
    text: String,
    leftButtonText:String? = null,
    leftButtonClickListener:() -> Unit = {},
    rightButtonText:String? = null,
    rightButtonClickListener:() -> Unit = {},
    ixiColor: IxiColor,
    headingAlignment: TextAlign = TextAlign.Start,
    textAlignment: TextAlign = TextAlign.Start,
    @ColorRes buttonColor:Int?
){
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        heading?.let {
            TypographyText(modifier = Modifier.fillMaxWidth(), text = heading, textStyle = IxiTypography.Body.Small.regular.copy(colorResource(id = ixiColor.textColor)), textAlign = headingAlignment)
            Spacer(modifier = Modifier.height(6.dp))
        }
        TypographyText(modifier = Modifier.fillMaxWidth(), text = text, textStyle = IxiTypography.Body.XSmall.regular.copy(colorResource(id = ixiColor.pressedColor)), textAlign = textAlignment)
        if(leftButtonText!=null || rightButtonText!=null){
            Spacer(modifier = Modifier.height(8.dp))
            InlineAlertButtonContainer(
                leftButtonText,
                leftButtonClickListener,
                rightButtonText,
                rightButtonClickListener,
                ixiColor,
                buttonColor
            )
        }
    }

}

@Composable
fun InlineAlertButtonContainer(
    leftButtonText:String? = null,
    leftButtonClickListener:() -> Unit = {},
    rightButtonText:String? = null,
    rightButtonClickListener:() -> Unit = {},
    ixiColor: IxiColor,
    @ColorRes buttonColor:Int?
){
    var buttonIxiColor:IxiColor?  =null
    buttonColor?.let {
        buttonIxiColor = IxiColor.Extra(R.color.n900,R.color.n900, buttonColor)
    }
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.offset(x = (-10).dp)) {
        leftButtonText?.let {
            ComposableTextButton(text = it, color =buttonIxiColor?:ixiColor, size = ButtonSize.Small, width = -2, onClick = leftButtonClickListener)
            Spacer(modifier = Modifier.width(8.dp))
        }
        rightButtonText?.let {
            ComposableTextButton(text = it, color = buttonIxiColor?:ixiColor, size = ButtonSize.Small, width = -2, onClick = rightButtonClickListener)
        }
    }


}

@Preview
@Composable
fun PreviewComposable(){
    ComposableInlineAlert(
        logo = R.drawable.ic_call_24,
        heading = "A short heading can be multiple liness this could also go into rwo lines",
        text = "Lorem ipsum dolor sit amet, consecteturds jdsjd sjkdks dk skds jkd skj",
        actionIcon = R.drawable.ic_search,
    )
}


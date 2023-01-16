package com.ixigo.design.sdk.components.inlinealert.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.buttons.IxiTertiaryButton
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiTypography

@Composable
fun ComposableInlineAlert(
    @DrawableRes logo: Int? = null,
    heading:String? = null,
    text:String,
    @DrawableRes rightIcon:Int? = null,
    leftButton:IxiTertiaryButton? = null,
    rightButton:IxiTertiaryButton? = null,
    onRightIconClickListener: (()->Unit)? = null,
    ixiColor: IxiColor = IxiColor.Extra(bg = R.color.b50, text = R.color.b500, pressed = R.color.b400)
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = ixiColor.bgColor), shape = RoundedCornerShape(10.dp))
    ) {
        Row(verticalAlignment = Alignment.Top, modifier = Modifier.padding(10.dp)) {
            Box(modifier = Modifier.weight(3f)){
                Row(verticalAlignment = Alignment.Top) {
                    logo?.let {
                        Image(modifier = Modifier.size(40.dp),painter = painterResource(id = logo), contentDescription = null)
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                    InlineAlertContent(
                        heading = heading,
                        text = text,
                        leftButton = leftButton,
                        rightButton = rightButton,
                        ixiColor = ixiColor
                    )
                }
            }
            Box(modifier = Modifier.weight(0.5f)) {
                rightIcon?.let {
                    Icon(modifier = Modifier
                        .size(15.dp)
                        .align(Alignment.TopEnd)
                        .clickable {
                            onRightIconClickListener?.invoke()
                        }, painter = painterResource(id = rightIcon), contentDescription = null)
                }
            }
        }
    }


}

@Composable
fun InlineAlertContent(
    heading: String? = null,
    text: String,
    leftButton: IxiTertiaryButton? = null,
    rightButton: IxiTertiaryButton? = null,
    ixiColor: IxiColor
){
    Column {
        heading?.let {
            Text(text = heading, style = IxiTypography.Body.Small.regular.copy(colorResource(id = ixiColor.textColor)))
            Spacer(modifier = Modifier.height(6.dp))
        }
        Text(text = text, style = IxiTypography.Body.XSmall.regular.copy(colorResource(id = ixiColor.pressedColor)))
        if(leftButton!=null || rightButton!=null){
            Spacer(modifier = Modifier.height(8.dp))
            leftButton?.setColor(ixiColor)
            rightButton?.setColor(ixiColor)
            InlineAlertButtonContainer(
                leftButton = leftButton,
                rightButton = rightButton
            )
        }
    }

}

@Composable
fun InlineAlertButtonContainer(
    leftButton:IxiTertiaryButton? = null,
    rightButton:IxiTertiaryButton? = null,
){
    Row(verticalAlignment = Alignment.CenterVertically) {
        leftButton?.let {
            AndroidView(
                factory = {
                    leftButton
                },
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        rightButton?.let {
            AndroidView(
                factory = {
                    rightButton
                },
            )
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
        rightIcon = R.drawable.ic_search
    )
}


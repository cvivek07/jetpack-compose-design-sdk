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
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.SdkManager
import com.ixigo.design.sdk.components.buttons.composable.ComposableTextButton
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiTypography

@Composable
fun ComposableInlineAlert(
    @DrawableRes logo: Int? = null,
    heading:String? = null,
    text:String,
    @DrawableRes rightIcon:Int? = null,
    leftButtonText:String? = null,
    leftButtonClickListener:() -> Unit = {},
    rightButtonText:String? = null,
    rightButtonClickListener:() -> Unit = {},
    onRightIconClickListener: (()->Unit)? = null,
    ixiColor: IxiColor = IxiColor.Extra(bg = R.color.b50, text = R.color.b500, pressed = R.color.b400)
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
                Row(verticalAlignment = Alignment.Top) {
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
    leftButtonText:String? = null,
    leftButtonClickListener:() -> Unit = {},
    rightButtonText:String? = null,
    rightButtonClickListener:() -> Unit = {},
    ixiColor: IxiColor
){
    Column {
        heading?.let {
            Text(text = heading, style = IxiTypography.Body.Small.regular.copy(colorResource(id = ixiColor.textColor)))
            Spacer(modifier = Modifier.height(6.dp))
        }
        Text(text = text, style = IxiTypography.Body.XSmall.regular.copy(colorResource(id = ixiColor.pressedColor)))
        if(leftButtonText!=null || rightButtonText!=null){
            Spacer(modifier = Modifier.height(8.dp))
            InlineAlertButtonContainer(
                leftButtonText,
                leftButtonClickListener,
                rightButtonText,
                rightButtonClickListener,
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
){
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.offset(x = (-10).dp)) {
        leftButtonText?.let {
            ComposableTextButton(text = it, color = SdkManager.getConfig().project.color, size = ButtonSize.Small, width = -2, onClick = leftButtonClickListener)
            Spacer(modifier = Modifier.width(8.dp))
        }
        rightButtonText?.let {
            ComposableTextButton(text = it, color = SdkManager.getConfig().project.color, size = ButtonSize.Small, width = -2, onClick = rightButtonClickListener)
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
        rightIcon = R.drawable.ic_search,
    )
}


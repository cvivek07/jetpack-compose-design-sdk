package com.ixigo.design.sdk.components.text.composable

import android.graphics.Typeface
import android.text.Spanned
import android.text.style.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.ixigo.design.sdk.components.styles.IxiFamily


@Composable
fun TypographyText(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) {

    Text(
        text = text,
        letterSpacing = 0.sp,
        style = textStyle,
        modifier = modifier,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        textAlign = textAlign,
    )
}

@Composable
fun TypographyText(
    spanned: Spanned,
    modifier: Modifier = Modifier,
    textStyle: TextStyle,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null,
) {
    Text(
        text = buildAnnotatedString {
            append(spanned.toAnnotatedString())
        },
        letterSpacing = 0.sp,
        style = textStyle,
        modifier = modifier,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        textAlign = textAlign,
    )
}

fun Spanned.toAnnotatedString(): AnnotatedString = buildAnnotatedString {
    val spanned = this@toAnnotatedString
    append(spanned.toString())
    getSpans(0, spanned.length, Any::class.java).forEach { span ->
        val start = getSpanStart(span)
        val end = getSpanEnd(span)
        when (span) {
            is StyleSpan -> when (span.style) {
                Typeface.BOLD -> addStyle(
                    SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontFamily = IxiFamily
                    ), start, end
                )
                Typeface.ITALIC -> addStyle(
                    SpanStyle(
                        fontStyle = FontStyle.Italic,
                        fontFamily = IxiFamily
                    ), start, end
                )
                Typeface.BOLD_ITALIC -> addStyle(
                    SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontFamily = IxiFamily
                    ), start, end
                )
            }
            is UnderlineSpan -> addStyle(
                SpanStyle(textDecoration = TextDecoration.Underline.plus(TextDecoration.Underline)),
                start,
                end
            )
            is ForegroundColorSpan -> addStyle(
                SpanStyle(color = Color(span.foregroundColor)),
                start,
                end
            )
            is StrikethroughSpan -> addStyle(
                SpanStyle(textDecoration = TextDecoration.LineThrough),
                start,
                end
            )
            is URLSpan -> addStyle(
                SpanStyle(
                    color = Color(0xff64B5F6),
                    textDecoration = TextDecoration.Underline
                ), start, end
            )
        }
    }
}
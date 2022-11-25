package com.ixigo.design_sdk.components.styles

import androidx.annotation.ColorRes
import com.ixigo.design.sdk.R


sealed class Colors(
    @ColorRes val bgColor: Int,
    @ColorRes val pressedColor: Int,
    @ColorRes val textColor: Int,
) {
    object Orange : Colors(R.color.o700, R.color.o600, R.color.n0)
    object Blue : Colors(R.color.b500, R.color.b400, R.color.n0)
    object Error : Colors(R.color.r400, R.color.r400, R.color.n0)
    object Warning : Colors(R.color.y500, R.color.y500, R.color.n0)
    object Success : Colors(R.color.g500, R.color.g500, R.color.n0)
    object Extension : Colors(R.color.p500, R.color.p500, R.color.n0)

    internal object Disabled : Colors(R.color.n40, R.color.n40, R.color.n300)

    internal object OrangeSecondary : Colors(R.color.o50, R.color.o100, R.color.o800)
    internal object BlueSecondary : Colors(R.color.b50, R.color.b100, R.color.b500)
    internal object ErrorSecondary : Colors(R.color.r50, R.color.r50, R.color.r500)
    internal object WarningSecondary : Colors(R.color.y100, R.color.y100, R.color.y700)
    internal object SuccessSecondary : Colors(R.color.g50, R.color.g50, R.color.g500)
    internal object ExtensionSecondary : Colors(R.color.p50, R.color.p50, R.color.p500)

    internal object OrangeTertiary :
        Colors(android.R.color.transparent, android.R.color.transparent, R.color.o800)

    internal object BlueTertiary :
        Colors(android.R.color.transparent, android.R.color.transparent, R.color.b500)

    internal object ErrorTertiary :
        Colors(android.R.color.transparent, android.R.color.transparent, R.color.r500)

    internal object WarningTertiary :
        Colors(android.R.color.transparent, android.R.color.transparent, R.color.y700)

    internal object SuccessTertiary :
        Colors(android.R.color.transparent, android.R.color.transparent, R.color.g500)

    internal object ExtensionTertiary :
        Colors(android.R.color.transparent, android.R.color.transparent, R.color.p500)
}

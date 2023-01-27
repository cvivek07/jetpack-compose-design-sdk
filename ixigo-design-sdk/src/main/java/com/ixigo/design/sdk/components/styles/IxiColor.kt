package com.ixigo.design.sdk.components.styles

import androidx.annotation.ColorRes
import com.ixigo.design.sdk.R


sealed class IxiColor(
    @ColorRes val bgColor: Int,
    @ColorRes val pressedColor: Int,
    @ColorRes val textColor: Int,
) {
    object Orange : IxiColor(R.color.o700, R.color.o600, R.color.n0)
    object Blue : IxiColor(R.color.b500, R.color.b400, R.color.n0)
    object Error : IxiColor(R.color.r400, R.color.r400, R.color.n0)
    object Warning : IxiColor(R.color.y500, R.color.y500, R.color.n0)
    object Success : IxiColor(R.color.g500, R.color.g500, R.color.n0)
    object Extension : IxiColor(R.color.p500, R.color.p500, R.color.n0)
    data class Extra(
        @ColorRes val bg: Int,
        @ColorRes val pressed: Int,
        @ColorRes val text: Int,
    ) : IxiColor(bg, pressed, text)

    internal object Disabled : IxiColor(R.color.n40, R.color.n40, R.color.n300)

    internal object OrangeSecondary : IxiColor(R.color.o50, R.color.o100, R.color.o800)
    internal object BlueSecondary : IxiColor(R.color.b50, R.color.b100, R.color.b500)
    internal object ErrorSecondary : IxiColor(R.color.r50, R.color.r50, R.color.r500)
    internal object WarningSecondary : IxiColor(R.color.y100, R.color.y100, R.color.y700)
    internal object SuccessSecondary : IxiColor(R.color.g50, R.color.g50, R.color.g500)
    internal object ExtensionSecondary : IxiColor(R.color.p50, R.color.p50, R.color.p500)
    internal object BlueBottomNavbarIos: IxiColor(R.color.white, android.R.color.transparent, R.color.b500)
    internal object OrangeBottomNavbarIos: IxiColor(R.color.white, android.R.color.transparent, R.color.o700)
    internal object BlueBottomNavbarAndroid: IxiColor(R.color.b50, R.color.b100, R.color.b500)
    internal object OrangeBottomNavbarAndroid: IxiColor(R.color.o50, R.color.o100, R.color.o800)
    internal object OrangeTertiary :
        IxiColor(android.R.color.transparent, android.R.color.transparent, R.color.o800)

    internal object BlueTertiary :
        IxiColor(android.R.color.transparent, android.R.color.transparent, R.color.b500)

    internal object ErrorTertiary :
        IxiColor(android.R.color.transparent, android.R.color.transparent, R.color.r500)

    internal object WarningTertiary :
        IxiColor(android.R.color.transparent, android.R.color.transparent, R.color.y700)

    internal object SuccessTertiary :
        IxiColor(android.R.color.transparent, android.R.color.transparent, R.color.g500)

    internal object ExtensionTertiary :
        IxiColor(android.R.color.transparent, android.R.color.transparent, R.color.p500)
}

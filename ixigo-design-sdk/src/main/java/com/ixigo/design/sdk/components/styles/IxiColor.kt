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
    internal object BlueBottomNavbar : IxiColor(R.color.b50, R.color.b100, R.color.b500)
    internal object OrangeBottomNavbar : IxiColor(R.color.o50, R.color.o100, R.color.o800)
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

open class IxiChipColor(
    @ColorRes val backgroundColor: Int = android.R.color.transparent,
    @ColorRes val unselectedBackgroundColor: Int = android.R.color.transparent,
    @ColorRes val strokeColor: Int = R.color.n800,
    @ColorRes val textColor: Int = R.color.n800,
    @ColorRes val unSelectedTextColor: Int = R.color.n800,
    @ColorRes val drawableTintColor: Int = R.color.n0,
) {
    object NEUTRAL : IxiChipColor(
        backgroundColor = R.color.n800,
        textColor = R.color.white,
        unselectedBackgroundColor = android.R.color.transparent,
        unSelectedTextColor = R.color.n800,
        drawableTintColor = R.color.n0,
        strokeColor = R.color.n800,
    )

    object BLUE : IxiChipColor(
        backgroundColor = R.color.b400,
        textColor = R.color.white,
        unselectedBackgroundColor = android.R.color.transparent,
        unSelectedTextColor = R.color.b400,
        drawableTintColor = R.color.n0,
        strokeColor = R.color.b400,
    )
    object GREEN : IxiChipColor(
        backgroundColor = R.color.g400,
        textColor = R.color.white,
        unselectedBackgroundColor = android.R.color.transparent,
        unSelectedTextColor = R.color.g400,
        drawableTintColor = R.color.n0,
        strokeColor = R.color.g400,
    )
    object RED : IxiChipColor(
        backgroundColor = R.color.r400,
        textColor = R.color.white,
        unselectedBackgroundColor = android.R.color.transparent,
        unSelectedTextColor = R.color.white,
        drawableTintColor = R.color.n0,
        strokeColor = R.color.r400,
    )
    object YELLOW : IxiChipColor(
        backgroundColor = R.color.y400,
        textColor = R.color.white,
        unselectedBackgroundColor = android.R.color.transparent,
        unSelectedTextColor = R.color.y400,
        drawableTintColor = R.color.n0,
        strokeColor = R.color.y400,
    )
    object PURPLE : IxiChipColor(
        backgroundColor = R.color.p400,
        textColor = R.color.white,
        unselectedBackgroundColor = android.R.color.transparent,
        unSelectedTextColor = R.color.p400,
        drawableTintColor = R.color.n0,
        strokeColor = R.color.p400,
    )

    object DISABLED : IxiChipColor(
        backgroundColor = android.R.color.transparent,
        textColor =R.color.n300,
        unselectedBackgroundColor = android.R.color.transparent,
        unSelectedTextColor = R.color.n300,
        drawableTintColor = R.color.n300,
        strokeColor = R.color.n300,
    )
}

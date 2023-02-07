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
    object Neutral : IxiColor(R.color.n500, R.color.n500, R.color.n0)
    data class Extra(
        @ColorRes val bg: Int,
        @ColorRes val pressed: Int,
        @ColorRes val text: Int,
    ) : IxiColor(bg, pressed, text)

    internal object Disabled : IxiColor(R.color.n40, R.color.n40, R.color.n300)
    // Bottom Navigation Bar can be of two colors only
    internal object BlueBottomNavbar : IxiColor(R.color.b50, R.color.b100, R.color.b500)
    internal object OrangeBottomNavbar : IxiColor(R.color.o50, R.color.o100, R.color.o800)

    companion object{
        fun mapFromAttrEnum(int: Int): IxiColor {
            return when (int) {
                0 -> Warning
                1 -> Extension
                2 -> Error
                3 -> Success
                4 -> Blue
                5 -> Neutral
                6 -> Orange
                else -> Neutral
            }
        }
    }

    fun mapSecStyle(colors: IxiColor):IxiColor = when (colors) {
        Blue -> IxiSecondaryColor.Blue
        Disabled -> Disabled
        Error -> IxiSecondaryColor.Error
        Extension -> IxiSecondaryColor.Extension
        Orange -> IxiSecondaryColor.Orange
        Success -> IxiSecondaryColor.Success
        Neutral -> IxiSecondaryColor.Neutral
        Warning -> IxiSecondaryColor.Warning
        else -> colors
    }

    fun mapTertiaryStyle(colors: IxiColor) = when (colors) {
        Blue -> IxiTertiaryColor.Blue
        Disabled -> Disabled
        Error -> IxiTertiaryColor.Error
        Extension -> IxiTertiaryColor.Extension
        Orange -> IxiTertiaryColor.Orange
        Success -> IxiTertiaryColor.Success
        Warning -> IxiTertiaryColor.Warning
        Neutral -> IxiTertiaryColor.Neutral
        else -> colors
    }
}

internal object IxiSecondaryColor{
    internal object Orange : IxiColor(R.color.o50, R.color.o100, R.color.o800)
    internal object Blue : IxiColor(R.color.b50, R.color.b100, R.color.b500)
    internal object Error : IxiColor(R.color.r50, R.color.r50, R.color.r500)
    internal object Warning : IxiColor(R.color.y100, R.color.y100, R.color.y700)
    internal object Success : IxiColor(R.color.g50, R.color.g50, R.color.g500)
    internal object Extension : IxiColor(R.color.p50, R.color.p50, R.color.p500)
    internal object Neutral : IxiColor(R.color.n40, R.color.n40, R.color.n500)
}

internal object IxiTertiaryColor{
    internal object Orange :
        IxiColor(android.R.color.transparent, android.R.color.transparent, R.color.o800)

    internal object Neutral :
        IxiColor(android.R.color.transparent, android.R.color.transparent, R.color.n800)

    internal object Blue :
        IxiColor(android.R.color.transparent, android.R.color.transparent, R.color.b500)

    internal object Error :
        IxiColor(android.R.color.transparent, android.R.color.transparent, R.color.r500)

    internal object Warning :
        IxiColor(android.R.color.transparent, android.R.color.transparent, R.color.y700)

    internal object Success :
        IxiColor(android.R.color.transparent, android.R.color.transparent, R.color.g500)

    internal object Extension :
        IxiColor(android.R.color.transparent, android.R.color.transparent, R.color.p500)
}


open class IxiChipColor(
    @ColorRes val backgroundColor: Int = android.R.color.transparent,
    @ColorRes val unselectedBackgroundColor: Int = android.R.color.transparent,
    @ColorRes val strokeColor: Int = R.color.n800,
    @ColorRes val unselectedStrokeColor: Int = R.color.n800,
    @ColorRes val textColor: Int = R.color.n800,
    @ColorRes val unSelectedTextColor: Int = R.color.n800,
    @ColorRes val drawableTintColor: Int = R.color.n0,
    @ColorRes val unselectedDrawableTintColor: Int = R.color.n0,
) {
    object NEUTRAL : IxiChipColor(
        backgroundColor = R.color.n800,
        textColor = R.color.white,
        unselectedBackgroundColor = android.R.color.transparent,
        unSelectedTextColor = R.color.n800,
        drawableTintColor = R.color.n0,
        strokeColor = R.color.n800,
        unselectedStrokeColor = R.color.n800,
        unselectedDrawableTintColor = R.color.n800
    )

    object BLUE : IxiChipColor(
        backgroundColor = R.color.b400,
        textColor = R.color.white,
        unselectedBackgroundColor = android.R.color.transparent,
        unSelectedTextColor = R.color.b400,
        drawableTintColor = R.color.n0,
        strokeColor = R.color.b400,
        unselectedStrokeColor = R.color.b400,
        unselectedDrawableTintColor = R.color.b400
    )
    object GREEN : IxiChipColor(
        backgroundColor = R.color.g400,
        textColor = R.color.white,
        unselectedBackgroundColor = android.R.color.transparent,
        unSelectedTextColor = R.color.g400,
        drawableTintColor = R.color.n0,
        strokeColor = R.color.g400,
        unselectedStrokeColor = R.color.g400,
        unselectedDrawableTintColor = R.color.g400
    )
    object RED : IxiChipColor(
        backgroundColor = R.color.r400,
        textColor = R.color.white,
        unselectedBackgroundColor = android.R.color.transparent,
        unSelectedTextColor = R.color.r400,
        drawableTintColor = R.color.n0,
        strokeColor = R.color.r400,
        unselectedStrokeColor = R.color.r400,
        unselectedDrawableTintColor = R.color.r400
    )
    object YELLOW : IxiChipColor(
        backgroundColor = R.color.y400,
        textColor = R.color.white,
        unselectedBackgroundColor = android.R.color.transparent,
        unSelectedTextColor = R.color.y400,
        drawableTintColor = R.color.n0,
        strokeColor = R.color.y400,
        unselectedStrokeColor = R.color.y400,
        unselectedDrawableTintColor = R.color.y400
    )
    object ORANGE : IxiChipColor(
        backgroundColor = R.color.o400,
        textColor = R.color.white,
        unselectedBackgroundColor = android.R.color.transparent,
        unSelectedTextColor = R.color.o400,
        drawableTintColor = R.color.n0,
        strokeColor = R.color.o400,
        unselectedStrokeColor = R.color.o400,
        unselectedDrawableTintColor = R.color.o400
    )
    object PURPLE : IxiChipColor(
        backgroundColor = R.color.p400,
        textColor = R.color.white,
        unselectedBackgroundColor = android.R.color.transparent,
        unSelectedTextColor = R.color.p400,
        drawableTintColor = R.color.n0,
        strokeColor = R.color.p400,
        unselectedStrokeColor = R.color.p400,
        unselectedDrawableTintColor = R.color.p400
    )

    object DISABLED : IxiChipColor(
        backgroundColor = android.R.color.transparent,
        textColor =R.color.n300,
        unselectedBackgroundColor = android.R.color.transparent,
        unSelectedTextColor = R.color.n300,
        drawableTintColor = R.color.n300,
        strokeColor = R.color.n300,
        unselectedStrokeColor = R.color.n300,
        unselectedDrawableTintColor = R.color.n300
    )

    data class Extra(
        @ColorRes val background: Int = android.R.color.transparent,
        @ColorRes val unselectedBackground: Int = android.R.color.transparent,
        @ColorRes val stroke: Int = R.color.n800,
        @ColorRes val unselectedStroke:Int = R.color.n800,
        @ColorRes val text: Int = R.color.n800,
        @ColorRes val unselectedText: Int = R.color.n800,
        @ColorRes val drawableTint: Int = R.color.n0,
        @ColorRes val unselectedDrawableTint: Int = R.color.n0,
    ) : IxiChipColor(
        backgroundColor = background,
        unselectedBackgroundColor = unselectedBackground,
        strokeColor = stroke,
        unselectedStrokeColor = unselectedStroke,
        textColor = text,
        unSelectedTextColor = unselectedText,
        drawableTintColor = drawableTint,
        unselectedDrawableTintColor = unselectedDrawableTint
    )
}

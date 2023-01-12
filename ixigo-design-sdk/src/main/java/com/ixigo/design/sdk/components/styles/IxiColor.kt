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
    @ColorRes val strokeColor: Int? = null,
    @ColorRes val textColor: Int = R.color.n800,
    @ColorRes val drawableTintColor: Int? = null,

){
    object PrimaryDisabled : IxiChipColor(
        backgroundColor = R.color.n40,
        textColor = R.color.n300,
        drawableTintColor = R.color.n300
    )

    object SecondaryDisabled : IxiChipColor(
        backgroundColor = R.color.n20,
        strokeColor = R.color.n40,
        textColor = R.color.n300,
        drawableTintColor = R.color.n300
    )

    object OutlinedDisabled : IxiChipColor(
        backgroundColor = android.R.color.transparent,
        strokeColor = R.color.n40,
        textColor = R.color.n300,
        drawableTintColor = R.color.n300
    )

    object TextDisabled : IxiChipColor(
        backgroundColor = android.R.color.transparent,
        textColor = R.color.n300,
        drawableTintColor = R.color.n300
    )
    object Primary{
        object NEUTRAL{
            val background900 = IxiChipColor(backgroundColor = R.color.n900, textColor = R.color.white)
            val background800 = IxiChipColor(backgroundColor = R.color.n800, textColor = R.color.white)
        }
        object BLUE{
            val background500 = IxiChipColor(backgroundColor = R.color.b500, textColor = R.color.white)
            val background400 = IxiChipColor(backgroundColor = R.color.b400, textColor = R.color.white)
        }
        object GREEN{
            val background500 = IxiChipColor(backgroundColor = R.color.g500, textColor = R.color.white)
            val background400 = IxiChipColor(backgroundColor = R.color.g400, textColor = R.color.white)
        }
        object RED{
            val background500 = IxiChipColor(backgroundColor = R.color.r500, textColor = R.color.white)
            val background400 = IxiChipColor(backgroundColor = R.color.r400, textColor = R.color.white)
        }
        object YELLOW{
            val background500 = IxiChipColor(backgroundColor = R.color.y500, textColor = R.color.white)
            val background400 = IxiChipColor(backgroundColor = R.color.y400, textColor = R.color.white)
        }
        object PURPLE{
            val background500 = IxiChipColor(backgroundColor = R.color.p500, textColor = R.color.white)
            val background400 = IxiChipColor(backgroundColor = R.color.p400, textColor = R.color.white)
        }
    }

    object Secondary{
        object NEUTRAL{
            val background40 = IxiChipColor(backgroundColor = R.color.n40, strokeColor = R.color.n100,  textColor = R.color.n800)
            val background80= IxiChipColor(backgroundColor = R.color.n80, strokeColor = R.color.n100, textColor = R.color.n800)
        }
        object BLUE{
            val background50 = IxiChipColor(backgroundColor = R.color.b50, strokeColor = R.color.b100,  textColor = R.color.b500)
            val background100 = IxiChipColor(backgroundColor = R.color.b100, strokeColor = R.color.b100, textColor = R.color.b500)
        }
        object GREEN{
            val background50 = IxiChipColor(backgroundColor = R.color.g50, strokeColor = R.color.g100,  textColor = R.color.g500)
            val background100 = IxiChipColor(backgroundColor = R.color.g100, strokeColor = R.color.g100, textColor = R.color.g500)
        }
        object RED{
            val background50 = IxiChipColor(backgroundColor = R.color.r50, strokeColor = R.color.r100,  textColor = R.color.r500)
            val background100 = IxiChipColor(backgroundColor = R.color.r100, strokeColor = R.color.r100, textColor = R.color.r500)
        }
        object YELLOW{
            val background50 = IxiChipColor(backgroundColor = R.color.y50, strokeColor = R.color.y100,  textColor = R.color.y500)
            val background100 = IxiChipColor(backgroundColor = R.color.y100, strokeColor = R.color.y100, textColor = R.color.y500)
        }
        object PURPLE{
            val background50 = IxiChipColor(backgroundColor = R.color.p50, strokeColor = R.color.p100,  textColor = R.color.p500)
            val background100 = IxiChipColor(backgroundColor = R.color.p100, strokeColor = R.color.p100, textColor = R.color.p500)
        }
    }

    object Outlined{
        object NEUTRAL{
            val stroke300 = IxiChipColor(strokeColor = R.color.n300,  textColor = R.color.n800)
            val background40Stroke300 = IxiChipColor(backgroundColor = R.color.n40, strokeColor = R.color.n300, textColor = R.color.n800)
        }
        object BLUE{
            val stroke300 = IxiChipColor(strokeColor = R.color.b300,  textColor = R.color.b500)
            val background50Stroke300 = IxiChipColor(backgroundColor = R.color.b50, strokeColor = R.color.b300, textColor = R.color.b500)
        }
        object GREEN{
            val stroke300 = IxiChipColor(strokeColor = R.color.g300,  textColor = R.color.g500)
            val background50Stroke300 = IxiChipColor(backgroundColor = R.color.g50, strokeColor = R.color.g300, textColor = R.color.g500)
        }
        object RED{
            val stroke300 = IxiChipColor(strokeColor = R.color.r300,  textColor = R.color.r500)
            val background50Stroke300 = IxiChipColor(backgroundColor = R.color.r50, strokeColor = R.color.r300, textColor = R.color.r500)
        }
        object YELLOW{
            val stroke300 = IxiChipColor(strokeColor = R.color.y300,  textColor = R.color.y500)
            val background50Stroke300 = IxiChipColor(backgroundColor = R.color.y50, strokeColor = R.color.y300, textColor = R.color.y500)
        }
        object PURPLE{
            val stroke300 = IxiChipColor(strokeColor = R.color.p300,  textColor = R.color.p500)
            val background50Stroke300 = IxiChipColor(backgroundColor = R.color.p50, strokeColor = R.color.p300, textColor = R.color.p500)
        }
    }

    object Text{
        object NEUTRAL{
            val text800 = IxiChipColor(textColor = R.color.n800)
            val background40Text800 = IxiChipColor(backgroundColor = R.color.n40, textColor = R.color.n800)
        }
        object BLUE{
            val text500 = IxiChipColor(textColor = R.color.b500)
            val background50Text500 = IxiChipColor(backgroundColor = R.color.b50, textColor = R.color.b500)
        }
        object GREEN{
            val text500 = IxiChipColor(textColor = R.color.g500)
            val background50Text500 = IxiChipColor(backgroundColor = R.color.g50, textColor = R.color.g500)
        }
        object RED{
            val text500 = IxiChipColor(textColor = R.color.r500)
            val background50Text500 = IxiChipColor(backgroundColor = R.color.r50, textColor = R.color.r500)
        }
        object YELLOW{
            val text500 = IxiChipColor(textColor = R.color.y500)
            val background50Text500 = IxiChipColor(backgroundColor = R.color.y50, textColor = R.color.y500)
        }
        object PURPLE{
            val text500 = IxiChipColor(textColor = R.color.p500)
            val background50Text500 = IxiChipColor(backgroundColor = R.color.p50, textColor = R.color.p500)
        }
    }
}

package com.ixigo.design.sdk.components.bottomsheets.helper

import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.fragment.app.FragmentManager
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetDialogFragment
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetView
import com.ixigo.design.sdk.components.styles.IxiColor

object IxiBottomSheetHelper {
    private fun addBasePropertiesToBottomSheet(ixiBottomSheetUiModel: IxiBottomSheetUiModel, bottomSheet: IxiBottomSheetDialogFragment):IxiBottomSheetDialogFragment{
        bottomSheet.setTitleText(ixiBottomSheetUiModel.titleText)
        bottomSheet.setMasterTitle(ixiBottomSheetUiModel.toolbarTitle)
        bottomSheet.setMasterSubtitle(ixiBottomSheetUiModel.toolbarSubtitle)
        bottomSheet.setBodyText(ixiBottomSheetUiModel.bodyText)
        bottomSheet.disableDragging(ixiBottomSheetUiModel.disableDragging)
        ixiBottomSheetUiModel.toolbarCloseIcon?.let {
            bottomSheet.setToolbarCloseIcon(it)
        }
        ixiBottomSheetUiModel.closeActionAlignment?.let {
            bottomSheet.setCloseActionAlignment(ixiBottomSheetUiModel.closeActionAlignment)
        }
        ixiBottomSheetUiModel.primaryButtonText?.let {
            bottomSheet.setPrimaryButton(it, ixiBottomSheetUiModel.primaryActionListener)
        }
        ixiBottomSheetUiModel.secondaryButtonText?.let {
            bottomSheet.setSecondaryButton(it, ixiBottomSheetUiModel.secondaryActionListener)
        }
        ixiBottomSheetUiModel.inlineAlertText?.let {
            bottomSheet.setInlineAlert(it, ixiBottomSheetUiModel.inlineAlertIxiColor)
        }
        return bottomSheet
    }

    fun showImageBottomSheet(ixiBottomSheetUiModel: IxiBottomSheetUiModel, fragmentManager: FragmentManager){
        val fragment = addBasePropertiesToBottomSheet(ixiBottomSheetUiModel, IxiBottomSheetDialogFragment.newInstance())
        fragment.setImageBackgroundColor(ixiBottomSheetUiModel.imageBackgroundColor)
        ixiBottomSheetUiModel.iconSize?.let {
            fragment.setIconSize(it)
        }
        fragment.setImage(ixiBottomSheetUiModel.image)
        ixiBottomSheetUiModel.inlineAlertText?.let {
            fragment.setInlineAlert(it, ixiBottomSheetUiModel.inlineAlertIxiColor)
        }
        fragment.show(fragmentManager, IxiBottomSheetDialogFragment.TAG)
    }


    fun showFeatureIconBottomSheet(ixiBottomSheetUiModel: IxiBottomSheetUiModel, fragmentManager: FragmentManager){
        val fragment = addBasePropertiesToBottomSheet(ixiBottomSheetUiModel, IxiBottomSheetDialogFragment.newInstance())
        ixiBottomSheetUiModel.iconSize?.let {
            fragment.setIconSize(it)
        }
        fragment.setImage(ixiBottomSheetUiModel.image)
        fragment.show(fragmentManager, IxiBottomSheetDialogFragment.TAG)
    }

    fun showNoIconBottomSheet(ixiBottomSheetUiModel: IxiBottomSheetUiModel, fragmentManager: FragmentManager){
        val fragment = addBasePropertiesToBottomSheet(ixiBottomSheetUiModel, IxiBottomSheetDialogFragment.newInstance())
        fragment.show(fragmentManager, IxiBottomSheetDialogFragment.TAG)
    }

    fun showBlankBottomSheet(ixiBottomSheetUiModel: IxiBottomSheetUiModel, fragmentManager: FragmentManager){
        val fragment = addBasePropertiesToBottomSheet(ixiBottomSheetUiModel, IxiBottomSheetDialogFragment.newInstance())
        ixiBottomSheetUiModel.view?.let {
            fragment.setView(ixiBottomSheetUiModel.view)
        }
        fragment.show(fragmentManager, IxiBottomSheetDialogFragment.TAG)
    }

    data class IxiBottomSheetUiModel(
        val titleText:String? = null,
        val toolbarTitle:String? = null,
        val toolbarSubtitle:String? = null,
        val bodyText:String? = null,
        @ColorRes val imageBackgroundColor:Int? = null,
        val iconSize:Float? = null,
        @DrawableRes val image:Int? = null,
        val primaryButtonText:String? = null,
        val primaryActionListener:(()->Unit)? = null,
        val secondaryButtonText:String? = null,
        val secondaryActionListener:(()->Unit)? = null,
        val view: View? = null,
        val disableDragging: Boolean = false,
        val inlineAlertText: String? = null,
        val inlineAlertIxiColor: IxiColor? = null,
        val closeActionAlignment: IxiBottomSheetView.ActionIconAlignment? = null,
        @DrawableRes val toolbarCloseIcon: Int? = null
    )
}
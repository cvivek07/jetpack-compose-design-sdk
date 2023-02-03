package com.ixigo.design.sdk.components.bottomsheets.helper

import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.fragment.app.FragmentManager
import com.ixigo.design.sdk.components.bottomsheets.fragment.BottomSheetImplementation

object IxiBottomSheetHelper {
    fun showImageBottomSheet(ixiBottomSheetUiModel: IxiBottomSheetUiModel, fragmentManager: FragmentManager){
        val fragment = BottomSheetImplementation.newInstance()
        fragment.setTitleText(ixiBottomSheetUiModel.titleText)
        fragment.setBodyText(ixiBottomSheetUiModel.bodyText)
        fragment.setImageBackgroundColor(ixiBottomSheetUiModel.imageBackgroundColor)
        ixiBottomSheetUiModel.iconSize?.let {
            fragment.setIconSize(it)
        }
        fragment.setImage(ixiBottomSheetUiModel.image)
        ixiBottomSheetUiModel.primaryButtonText?.let {
            fragment.setPrimaryButton(it, ixiBottomSheetUiModel.primaryActionListener)
        }
        ixiBottomSheetUiModel.secondaryButtonText?.let {
            fragment.setSecondaryButton(it, ixiBottomSheetUiModel.secondaryActionListener)
        }
        fragment.show(fragmentManager, BottomSheetImplementation.TAG)
    }


    fun showFeatureIconBottomSheet(ixiBottomSheetUiModel: IxiBottomSheetUiModel, fragmentManager: FragmentManager){
        val fragment = BottomSheetImplementation.newInstance()
        fragment.setTitleText(ixiBottomSheetUiModel.titleText)
        fragment.setBodyText(ixiBottomSheetUiModel.bodyText)
        ixiBottomSheetUiModel.iconSize?.let {
            fragment.setIconSize(it)
        }
        fragment.setImage(ixiBottomSheetUiModel.image)
        ixiBottomSheetUiModel.primaryButtonText?.let {
            fragment.setPrimaryButton(it, ixiBottomSheetUiModel.primaryActionListener)
        }
        ixiBottomSheetUiModel.secondaryButtonText?.let {
            fragment.setSecondaryButton(it, ixiBottomSheetUiModel.secondaryActionListener)
        }
        fragment.show(fragmentManager, BottomSheetImplementation.TAG)
    }

    fun showNoIconBottomSheet(ixiBottomSheetUiModel: IxiBottomSheetUiModel, fragmentManager: FragmentManager){
        val fragment = BottomSheetImplementation.newInstance()
        fragment.setTitleText(ixiBottomSheetUiModel.titleText)
        fragment.setBodyText(ixiBottomSheetUiModel.bodyText)
        ixiBottomSheetUiModel.iconSize?.let {
            fragment.setIconSize(it)
        }
        ixiBottomSheetUiModel.primaryButtonText?.let {
            fragment.setPrimaryButton(it, ixiBottomSheetUiModel.primaryActionListener)
        }
        ixiBottomSheetUiModel.secondaryButtonText?.let {
            fragment.setSecondaryButton(it, ixiBottomSheetUiModel.secondaryActionListener)
        }
        fragment.show(fragmentManager, BottomSheetImplementation.TAG)
    }

    fun showBlankBottomSheet(ixiBottomSheetUiModel: IxiBottomSheetUiModel, fragmentManager: FragmentManager){
        val fragment = BottomSheetImplementation.newInstance()
        fragment.setMasterTitle(ixiBottomSheetUiModel.titleText)
        ixiBottomSheetUiModel.view?.let {
            fragment.setView(ixiBottomSheetUiModel.view)
        }
        ixiBottomSheetUiModel.primaryButtonText?.let {
            fragment.setPrimaryButton(it, ixiBottomSheetUiModel.primaryActionListener)
        }
        ixiBottomSheetUiModel.secondaryButtonText?.let {
            fragment.setSecondaryButton(it, ixiBottomSheetUiModel.secondaryActionListener)
        }
        fragment.show(fragmentManager, BottomSheetImplementation.TAG)
    }

    data class IxiBottomSheetUiModel(
    val titleText:String? = null,
    val bodyText:String? = null,
    @ColorRes val imageBackgroundColor:Int? = null,
    val iconSize:Float? = null,
    @DrawableRes val image:Int? = null,
    val primaryButtonText:String? = null,
    val primaryActionListener:(()->Unit)? = null,
    val secondaryButtonText:String? = null,
    val secondaryActionListener:(()->Unit)? = null,
    val view: View? = null
    )
}
package com.ixigo.design.sdk

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.databinding.FragmentInputFieldsBinding
import com.ixigo.design_sdk.components.styles.Colors

class InputFieldsFragment : Fragment() {

    private var _binding: FragmentInputFieldsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentInputFieldsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.inputField1?.apply {
            setLabel("Label")

            setActionText("Add-On")
            setHelperText("This is helper Text")
            setEndImageDrawable(R.drawable.ic_baseline_cancel_24)
            setStartImageDrawable(R.drawable.ic_baseline_cancel_24)
            setMaxCharCount(30)
            setColor(Colors.Error)
            setActionTextClickListener {
                Log.e("Action", "ActionTextClick")
            }
            setDrawableStartClickListener {
                Log.e("Action", "DrawableStart Click")

            }
            setDrawableEndClickListener {
                Log.e("Action", "\"DrawableEnd Click")
            }
        }

        _binding?.inputField2?.apply {
            setLabel("Label")
            setStartImageDrawable(R.drawable.ic_baseline_cancel_24)
            setMaxCharCount(10)
            setActionTextClickListener {
                Log.e("Action", "ActionTextClick")
            }
            setDrawableStartClickListener {
                Log.e("Action", "DrawableStart Click")

            }
            setDrawableEndClickListener {
                Log.e("Action", "\"DrawableEnd Click")
            }
        }


        _binding?.inputField3?.apply {
            setLabel("Label")
            setStartImageDrawable(R.drawable.ic_baseline_cancel_24)
            setColor(Colors.Warning)
            setActionTextClickListener {
                Log.e("Action", "ActionTextClick")
            }
            setDrawableStartClickListener {
                Log.e("Action", "DrawableStart Click")

            }
            setDrawableEndClickListener {
                Log.e("Action", "\"DrawableEnd Click")
            }
        }

        _binding?.inputField4?.apply {
            setLabel("Label")
            setColor(Colors.Success)
            setStartImageDrawable(R.drawable.ic_baseline_cancel_24)
            setMaxCharCount(10)
            setActionTextClickListener {
                Log.e("Action", "ActionTextClick")
            }
            setDrawableStartClickListener {
                Log.e("Action", "DrawableStart Click")

            }
            setDrawableEndClickListener {
                Log.e("Action", "\"DrawableEnd Click")
            }
        }

        _binding?.inputField5?.apply {
            setLabel("Label")
            setMaxCharCount(100)
            setColor(Colors.Error)
            setActionTextClickListener {
                Log.e("Action", "ActionTextClick")
            }
            setDrawableStartClickListener {
                Log.e("Action", "DrawableStart Click")

            }
            setDrawableEndClickListener {
                Log.e("Action", "\"DrawableEnd Click")
            }
        }

        _binding?.inputField6?.apply {
            setLabel("Label")
            setColor(Colors.Extension)
            setMaxCharCount(10)
            setActionTextClickListener {
                Log.e("Action", "ActionTextClick")
            }
            setDrawableStartClickListener {
                Log.e("Action", "DrawableStart Click")

            }
            setDrawableEndClickListener {
                Log.e("Action", "\"DrawableEnd Click")
            }
        }

        _binding?.inputField7?.apply {
            setLabel("Label")
            setActionTextClickListener {
                Log.e("Action", "ActionTextClick")
            }
            setDrawableStartClickListener {
                Log.e("Action", "DrawableStart Click")

            }
            setDrawableEndClickListener {
                Log.e("Action", "\"DrawableEnd Click")
            }
        }

    }
}
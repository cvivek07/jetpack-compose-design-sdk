package com.ixigo.design.sdk

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

abstract class BaseFragment: Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? AppCompatActivity)?.let{it.supportActionBar?.title = Navigation.findNavController(it, R.id.nav_host_fragment_content_sample).currentDestination?.label}
    }
}
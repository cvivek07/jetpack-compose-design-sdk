package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout.MODE_AUTO
import com.google.android.material.tabs.TabLayout.MODE_FIXED
import com.ixigo.design.sdk.components.tabs.base.TabType
import com.ixigo.design.sdk.components.topappbar.TabItem
import com.ixigo.design.sdk.databinding.FragmentButtonsBinding
import com.ixigo.design.sdk.databinding.FragmentTabBarBinding
import com.ixigo.design.sdk.databinding.FragmentTopAppBarBinding
import kotlin.concurrent.fixedRateTimer

class TabBarFragment: Fragment() {
    private var _binding: FragmentTabBarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabBarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragments = listOf(TypographyFragment(), ButtonsFragment())
        val dataList = listOf(TabItem("Typography", 0,0), TabItem("Buttons", 0,0))

        binding.viewPager.adapter = PagerAdapter(parentFragmentManager, lifecycle, fragments)
        binding.tabLayout.tabType = TabType.LINED
        binding.tabLayout.tabMode =  MODE_FIXED
        binding.tabLayout.setupWithViewPager2(binding.viewPager, dataList)

        val fragments2 = listOf(ProgressStepFragment(), InputFieldsFragment())
        val dataList2 = listOf(TabItem("Progress Step", 0,0), TabItem("Input Field", 0,0))

        binding.viewPager2.adapter = PagerAdapter(parentFragmentManager, lifecycle, fragments2)
        binding.linedTabLayout.tabType = TabType.PILL
        binding.tabLayout.tabMode =  MODE_AUTO
        binding.linedTabLayout.setupWithViewPager2(binding.viewPager2, dataList2)
    }

    class PagerAdapter(
        fm: FragmentManager,
        lifecycle: Lifecycle,
        private val contents: List<Fragment>
    ) : FragmentStateAdapter(fm, lifecycle) {

        override fun getItemCount(): Int {
            return contents.size
        }

        override fun createFragment(position: Int): Fragment {
            return contents[position]
        }
    }
}
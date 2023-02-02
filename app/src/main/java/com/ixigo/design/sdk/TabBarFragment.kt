package com.ixigo.design.sdk


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout.*
import com.ixigo.design.sdk.components.tabs.TabType
import com.ixigo.design.sdk.components.topappbar.TabDataItem
import com.ixigo.design.sdk.databinding.FragmentTabBarBinding


class TabBarFragment : Fragment() {
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
        binding.tabLayout.tabMode = MODE_FIXED

        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: Tab) {
                val fragment = when (tab.position) {
                    0 -> {
                        TypographyFragment()
                    }
                    1 -> {
                        ButtonsFragment()
                    }
                    2 -> {
                        ProgressStepFragment()
                    }
                    3 -> {
                        InputFieldsFragment()
                    }
                    else -> {
                        TypographyFragment()
                    }
                }
                val fm: FragmentManager = childFragmentManager
                val ft: FragmentTransaction = fm.beginTransaction()
                ft.replace(R.id.viewPager, fragment)
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ft.commit()
            }

            override fun onTabUnselected(tab: Tab) {

            }

            override fun onTabReselected(tab: Tab) {}
        })
        binding.tabLayout.addTab(
            TabDataItem(
                "Typography",
                0,
                0,
            )
        )
        binding.tabLayout.addTab(
            TabDataItem(
                "Buttons",
                0,
                0,
            )
        )

        binding.tabLayout.addTab(
            TabDataItem(
                "Progress Step",
                0,
                0,
            )
        )

        binding.tabLayout.addTab(
            TabDataItem(
                "Input Field",
                0,
                0,
            )
        )
        val fragments2 = listOf(ProgressStepFragment(), InputFieldsFragment())
        val dataList2 = listOf(
            TabDataItem("Progress Step", 0, 0),
            TabDataItem("Buttons", 0, 0)
        )

        binding.viewPager2.adapter = PagerAdapter(parentFragmentManager, lifecycle, fragments2)
        binding.linedTabLayout.tabType = TabType.PILL
        binding.tabLayout.tabMode = MODE_AUTO
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
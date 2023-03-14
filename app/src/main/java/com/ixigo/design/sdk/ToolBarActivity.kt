package com.ixigo.design.sdk

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ixigo.design.sdk.components.srp.composables.SrpModel
import com.ixigo.design.sdk.components.tabs.TabType
import com.ixigo.design.sdk.components.topappbar.*
import com.ixigo.design.sdk.components.topappbar.menu.IxiMenu
import com.ixigo.design.sdk.components.topappbar.menu.IxiMenuProvider
import com.ixigo.design.sdk.databinding.ActivityToolBarBinding

class ToolBarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityToolBarBinding

    companion object {
        const val BASIC_TOOLBAR = 0
        const val SUBTITLED_TOOLBAR = 1
        const val SEARCH_TOOLBAR = 2
        const val SEGMENT_CONTROL_TOOLBAR = 3
        const val SRP_TOOLBAR = 4
        const val TABBED_TOOLBAR = 5
        const val TOOLBAR_TYPE = "toolbar type"

        fun startActivity(context: Context, toolbarType: Int) {
            val intent = Intent(context, ToolBarActivity::class.java)
            intent.putExtra(TOOLBAR_TYPE, toolbarType)
            context.startActivity(intent)
        }
    }

    private val toolbarType by lazy { intent.getIntExtra(TOOLBAR_TYPE, BASIC_TOOLBAR) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToolBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        when (toolbarType) {
            BASIC_TOOLBAR -> basicToolbar()
            SUBTITLED_TOOLBAR -> basicSubTitledToolbar()
            SEARCH_TOOLBAR -> searchToolbar()
            SEGMENT_CONTROL_TOOLBAR -> segmentedControlToolbar()
            SRP_TOOLBAR -> srpToolbar()
            TABBED_TOOLBAR -> tabbedToolbar()
        }
    }

    fun basicToolbar() {
        val toolbar = IxiAppBar(context = this)
        toolbar.setTitle("Title")
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.n0))
        toolbar.addMenuProvider(object : IxiMenuProvider {
            override fun provideMenu(): List<IxiMenu> {
                return listOf()
            }

            override fun onMenuItemClick(id: Int) {
                when (id) {
                    android.R.id.home -> {
                        finish()
                        Log.e("ToolbarActivity", "Back Arrow clicked")
                    }
                }
            }
        })
        binding.appBar.removeAllViews()
        binding.appBar.addView(toolbar)
    }

    fun basicSubTitledToolbar() {
        val toolbar = IxiAppBar(context = this)
        toolbar.setTitle("Title")
        toolbar.setSubTitle("Very Long Sub-title")
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.n0))
        toolbar.addMenuProvider(object : IxiMenuProvider {
            override fun provideMenu(): List<IxiMenu> {
                return listOf(
                    IxiMenu(0, null, R.drawable.ic_baseline_cancel_24),
                    IxiMenu(1, "Done")
                )
            }

            override fun onMenuItemClick(id: Int) {
                when (id) {
                    android.R.id.home -> {
                        finish()
                        Log.e("ToolbarActivity", "Back Arrow clicked")
                    }
                    0 -> {
                        Log.e("ToolbarActivity", "$id item clicked")
                    }
                    1 -> {
                        Log.e("ToolbarActivity", "$id item clicked")
                    }
                }
            }
        })
        binding.appBar.removeAllViews()
        binding.appBar.addView(toolbar)

    }

    fun searchToolbar() {
        val toolbar = IxiSearchBar(context = this)
        toolbar.addMenuProvider(object : IxiMenuProvider {
            override fun provideMenu(): List<IxiMenu> {
                return listOf(
//                    IxiMenu(0, null, R.drawable.ic_baseline_cancel_24),
                )
            }

            override fun onMenuItemClick(id: Int) {
                when (id) {
                    android.R.id.home -> {
                        finish()
                        Log.e("ToolbarActivity", "Back Arrow clicked")
                    }
                    0 -> {
                        Log.e("ToolbarActivity", "$id item clicked")
                    }
                    1 -> {
                        Log.e("ToolbarActivity", "$id item clicked")
                    }
                }
            }
        })

        binding.appBar.removeAllViews()
        binding.appBar.addView(toolbar)
        binding.appBar.elevation = 100F
    }

    fun segmentedControlToolbar() {
        val toolbar = IxiSegmentedControlBar(context = this)
        toolbar.segments = listOf("Segment 1", "Segment 2", "Segment 3")
        toolbar.addMenuProvider(object : IxiMenuProvider {
            override fun provideMenu(): List<IxiMenu> {
                return listOf()
            }

            override fun onMenuItemClick(id: Int) {
                when (id) {
                    android.R.id.home -> {
                        finish()
                        Log.e("ToolbarActivity", "Back Arrow clicked")
                    }
                    0 -> {
                        Log.e("ToolbarActivity", "$id item clicked")
                    }
                    1 -> {
                        Log.e("ToolbarActivity", "$id item clicked")
                    }
                }
            }
        })
        binding.appBar.removeAllViews()
        binding.appBar.addView(toolbar)
        binding.appBar.elevation = 100F
    }

    fun srpToolbar() {
        val toolbar = IxiSrpToolbar(context = this)

        toolbar.setData(SrpModel("DLI", R.drawable.right_arrow, "FBD 15 Dec 2022 1 Traveller"))
        toolbar.setOnClickListener {
            "Clicked".toToast(this)
        }
        toolbar.addMenuProvider(object : IxiMenuProvider {
            override fun provideMenu(): List<IxiMenu> {
                return listOf(IxiMenu(0, null, R.drawable.ic_baseline_cancel_24))
            }

            override fun onMenuItemClick(id: Int) {
                when (id) {
                    android.R.id.home -> {
                        finish()
                        Log.e("ToolbarActivity", "Back Arrow clicked")
                    }
                    0 -> {
                        Log.e("ToolbarActivity", "$id item clicked")
                    }
                    1 -> {
                        Log.e("ToolbarActivity", "$id item clicked")
                    }
                }
            }
        })

        binding.appBar.removeAllViews()
        binding.appBar.addView(toolbar)
        binding.appBar.elevation = 100F
    }


    fun tabbedToolbar() {
        val listTabsName = listOf(
            TabDataItem("Buttons", R.drawable.ic_search, 0, ),
            TabDataItem("InputField", 0, R.drawable.ic_search, ),
            TabDataItem("Progress Steps", 0, 0, ),
            TabDataItem(
                "Typography",
                R.drawable.ic_search,
                R.drawable.ic_baseline_cancel_24,

            )
        )
        val fragmentList = listOf(
            ButtonsFragment(),
            InputFieldsFragment(),
            ProgressStepFragment(),
            TypographyFragment()
        )
        val toolbar = IxiTabbedToolBar(context = this)
        toolbar.setData(listTabsName)
        toolbar.setTabType(TabType.PILL)
        val adapter = PagerAdapter(supportFragmentManager, lifecycle, fragmentList)
        toolbar.setupViewPager(binding.viewPager, adapter)

        toolbar.addMenuProvider(object : IxiMenuProvider {
            override fun provideMenu(): List<IxiMenu> {
                return listOf()
            }

            override fun onMenuItemClick(id: Int) {
                when (id) {
                    android.R.id.home -> {
                        finish()
                        Log.e("ToolbarActivity", "Back Arrow clicked")
                    }
                    0 -> {
                        Log.e("ToolbarActivity", "$id item clicked")
                    }
                    1 -> {
                        Log.e("ToolbarActivity", "$id item clicked")
                    }
                }
            }
        })

        binding.appBar.removeAllViews()
        binding.appBar.addView(toolbar)
        binding.appBar.elevation = 100F
    }

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
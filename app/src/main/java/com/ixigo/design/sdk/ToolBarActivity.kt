package com.ixigo.design.sdk

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ixigo.design.sdk.components.search.IxiSearchView
import com.ixigo.design.sdk.components.topappbar.IxiAppBar
import com.ixigo.design.sdk.components.topappbar.IxiSearchBar
import com.ixigo.design.sdk.components.topappbar.IxiSegmentedControlBar
import com.ixigo.design.sdk.components.topappbar.IxiToolBar
import com.ixigo.design.sdk.components.topappbar.menu.IxiMenu
import com.ixigo.design.sdk.components.topappbar.menu.IxiMenuProvider
import com.ixigo.design.sdk.databinding.ActivitySampleBinding
import com.ixigo.design.sdk.databinding.ActivityToolBarBinding

class ToolBarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityToolBarBinding

    companion object {
        const val BASIC_TOOLBAR = 0
        const val SUBTITLED_TOOLBAR = 1
        const val SEARCH_TOOLBAR = 2
        const val SEGMENT_CONTROL_TOOLBAR = 3
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
}
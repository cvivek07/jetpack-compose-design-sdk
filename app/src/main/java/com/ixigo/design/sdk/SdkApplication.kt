package com.ixigo.design.sdk

import android.app.Application

class SdkApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SdkManager.initSdk(DesignConfig(Project.FLIGHT))
    }
}
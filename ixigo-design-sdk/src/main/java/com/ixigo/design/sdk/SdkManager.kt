package com.ixigo.design.sdk

object SdkManager {
    private var config: DesignConfig? = null

    fun initSdk(config: DesignConfig) {
        this.config = config
    }

    fun getConfig() = config
        ?: throw IllegalStateException("SDK is not initialised. PLease initialise sdk using initSdk() in SdkManager")
}

data class DesignConfig(val project: Project)
enum class Project {
    TRAIN,
    FLIGHT,
    ABHIBUS,
    CONFIRM_TICKET
}

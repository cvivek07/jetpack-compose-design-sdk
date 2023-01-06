package com.ixigo.design.sdk

/**
 * Manages and Initialise the sdk.
 * Make entry in Application class of your App and initialise the sdk.
 * This is the entry point to setup the sdk to be used in any application.
 */
object SdkManager {
    private var config: DesignConfig? = null

    /**
     * Initialises the sdk. app will throw IllegalStateException in case we don't initialise the sdk
     * @param config: Configurations to initialise the sdk
     */
    fun initSdk(config: DesignConfig) {
        this.config = config
    }

    /**
     * provides the same configuration which is used to initialise the sdk by the client.
     *
     * @return [DesignConfig] with which sdk is initialised.
     */
    internal fun getConfig() = config
        ?: throw IllegalStateException("SDK is not initialised. PLease initialise sdk using initSdk() in SdkManager")
}

/**
 * Configuration needed to initialise sdk. Add more information in this class if needed.
 *
 * @param project provide the project to setup app wise theme. Can be selected from any of 4 values
 * i.e. [Project.TRAIN], [Project.FLIGHT], [Project.ABHIBUS], [Project.CONFIRM_TICKET]
 */
data class DesignConfig(val project: Project)


enum class Project {
    TRAIN,
    FLIGHT,
    ABHIBUS,
    CONFIRM_TICKET
}

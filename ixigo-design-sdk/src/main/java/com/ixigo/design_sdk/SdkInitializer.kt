package com.ixigo.design_sdk

object SdkInitializer {
    var projectName: Projects? = null
        private set
        get() =
            field ?: Projects.TRAIN//throw java.lang.RuntimeException("Design Sdk is not initialised, Please initialise the sdk by calling initSdk(config: DesignConfig)")



    fun initSdk(config: DesignConfig) {

    }
}

abstract class DesignConfig(val abc: String)
enum class Projects {
    TRAIN,
    FLIGHT,
    ABHIBUS,
    CONFIRM_TICKET
}

fun test() {
    SdkInitializer.projectName.toString()
}
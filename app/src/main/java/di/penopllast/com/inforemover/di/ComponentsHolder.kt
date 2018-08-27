package com.di.penopllast.vklikesremover.di

import di.penopllast.com.inforemover.application.RemoverApp


class ComponentsHolder(private val context: RemoverApp) {
    var appComponent: AppComponent? = null
        private set

    fun init() {
        appComponent = DaggerAppComponent
                .builder()
                .application(context)
                .build()
    }

}

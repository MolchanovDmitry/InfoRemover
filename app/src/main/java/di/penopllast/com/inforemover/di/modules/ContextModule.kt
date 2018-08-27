package com.di.penopllast.vklikesremover.di.module

import android.content.Context

import dagger.Module
import dagger.Provides
import di.penopllast.com.inforemover.application.RemoverApp

@Module
class ContextModule {

    @Provides
    internal fun provideContext(app: RemoverApp): Context {
        return app.applicationContext
    }

}

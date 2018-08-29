package com.di.penopllast.vklikesremover.di

import com.di.penopllast.vklikesremover.di.module.ContextModule
import com.di.penopllast.vklikesremover.di.module.RepositoryModule

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import di.penopllast.com.inforemover.application.RemoverApp
import di.penopllast.com.inforemover.presentation.presenters.impl.AppListPresenterImpl

@Singleton
@Component(modules = arrayOf(ContextModule::class, RepositoryModule::class))
interface AppComponent {

    fun inject(appListPresenter: AppListPresenterImpl)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: RemoverApp): Builder

        fun build(): AppComponent
    }
}

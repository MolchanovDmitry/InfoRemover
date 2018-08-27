package com.di.penopllast.vklikesremover.di.module

import android.content.Context


import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import di.penopllast.com.inforemover.data.repositories.RepositoryDb
import di.penopllast.com.inforemover.data.repositories.RepositoryPreference
import di.penopllast.com.inforemover.data.repositories.impl.RepositoryDbImpl
import di.penopllast.com.inforemover.data.repositories.impl.RepositoryPreferenceImpl

@Module
class RepositoryModule {

    @Provides
    @Singleton
    internal fun provideRepositoryNetwork(context: Context): RepositoryDb {
        return RepositoryDbImpl(context)
    }

    @Provides
    @Singleton
    internal fun provideRepositoryPreference(context: Context): RepositoryPreference {
        return RepositoryPreferenceImpl(context)
    }


}

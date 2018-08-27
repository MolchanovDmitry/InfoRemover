package di.penopllast.com.inforemover.data.repositories.impl

import android.content.Context

import com.ironz.binaryprefs.BinaryPreferencesBuilder
import com.ironz.binaryprefs.Preferences

import di.penopllast.com.inforemover.data.repositories.RepositoryPreference

class RepositoryPreferenceImpl(context: Context) : RepositoryPreference {

    private val preferences: Preferences = BinaryPreferencesBuilder(context)
            .name("user_data")
            .build()

}

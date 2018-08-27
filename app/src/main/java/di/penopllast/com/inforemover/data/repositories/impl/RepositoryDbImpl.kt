package di.penopllast.com.inforemover.data.repositories.impl

import android.arch.persistence.room.Room
import android.content.Context

import di.penopllast.com.inforemover.data.repositories.RepositoryDb
import di.penopllast.com.inforemover.entities.room.AppDataBase

class RepositoryDbImpl(context: Context) : RepositoryDb {

    private val db: AppDataBase = Room.databaseBuilder(context, AppDataBase::class.java,
            "database").build()

}

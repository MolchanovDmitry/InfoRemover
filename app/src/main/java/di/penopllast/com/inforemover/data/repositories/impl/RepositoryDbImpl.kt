package di.penopllast.com.inforemover.data.repositories.impl

import android.arch.persistence.room.Room
import android.content.Context
import di.penopllast.com.inforemover.application.Utils.Util

import di.penopllast.com.inforemover.data.repositories.RepositoryDb
import di.penopllast.com.inforemover.entities.room.AppDataBase
import di.penopllast.com.inforemover.entities.room.SelectedApp

class RepositoryDbImpl(context: Context) : RepositoryDb {

    private val db: AppDataBase = Room.databaseBuilder(context, AppDataBase::class.java,
            "database").build()

    override fun insertApp(packageName: String, name: String) {
        Util.print("add $name")
        db.selectedAppDao().insert(SelectedApp(packageName, name))
    }

    override fun deleteApp(packageName: String, name: String) {
        Util.print("delete $name")
        db.selectedAppDao().delete(SelectedApp(packageName, name))
    }

    override fun printData(){
        Util.print("print")
        val appList = db.selectedAppDao().getAll()
        for(item in appList){
            Util.print(item.toString())
        }
    }

}

package di.penopllast.com.inforemover.entities.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(SelectedApp::class), version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun selectedAppDao(): SelectedApp

}

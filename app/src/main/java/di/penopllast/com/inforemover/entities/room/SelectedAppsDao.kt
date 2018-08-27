package di.penopllast.com.inforemover.entities.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface SelectedAppsDao {
    @Query("SELECT * FROM SelectedApp")
    fun getAll(): List<SelectedApp>

    @Insert
    fun insert(app: SelectedApp)

    @Delete
    fun delete(app: SelectedApp)
}

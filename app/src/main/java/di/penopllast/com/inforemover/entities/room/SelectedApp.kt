package di.penopllast.com.inforemover.entities.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
class SelectedApp {

    @PrimaryKey
    lateinit var pack: String;

    lateinit var name: String
}
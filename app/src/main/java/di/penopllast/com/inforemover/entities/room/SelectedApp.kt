package di.penopllast.com.inforemover.entities.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
class SelectedApp(@PrimaryKey var packageName: String, val name: String)
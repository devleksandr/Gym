package com.shurik.gym.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity (tableName = "exercises")
class ExerciseEntity (@PrimaryKey (autoGenerate = true) var id : Int?,
                      @ColumnInfo (name = "exercise") var exercise : String) {
    constructor():this(null,"")
}
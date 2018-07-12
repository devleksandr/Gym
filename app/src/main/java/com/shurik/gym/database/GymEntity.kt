package com.shurik.gym.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity (tableName = "gym")
class GymEntity (@PrimaryKey (autoGenerate = true) var id : Int?,
                 @ColumnInfo (name = "exercise_type") var exerciseType : String,
                 @ColumnInfo (name = "sets_count") var countSets : String,
                 @ColumnInfo (name = "repeats_count") var countRepeats : String,
                 @ColumnInfo (name = "weight_for_set") var weight : String,
                 @ColumnInfo (name = "date") var date : String)
{
    constructor():this (null,"","","", "","")
}
package com.shurik.gym.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity (tableName = "gym")
class GymEntity (@PrimaryKey (autoGenerate = true) var id : Int?,
                 @ColumnInfo (name = "exercise_type") var exerciseType : String,
                 @ColumnInfo (name = "sets_count") var countSets : Int,
                 @ColumnInfo (name = "repeats_count") var countRepeats : Int,
                 @ColumnInfo (name = "weight_for_set") var weight : Array<Int>,
                 @ColumnInfo (name = "date") var date : Date)
{
    constructor():this (null,"",0,0, arrayOf(0),Date())
}
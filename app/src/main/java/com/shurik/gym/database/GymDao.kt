package com.shurik.gym.database

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao
interface GymDao {

    companion object {

        const val DATE = "date"
    }
        @Query("SELECT * from gym")
        fun getGym () : List<GymEntity>

        @Query ("SELECT * from gym where $DATE=:date")
        fun getGymByDate (date: String) : List<GymEntity>

        @Insert(onConflict = REPLACE)
        fun insertGym (gymEntity: GymEntity)

        @Delete
        fun deleteGym (gymEntity: GymEntity)
}
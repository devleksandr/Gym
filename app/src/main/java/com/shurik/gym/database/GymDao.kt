package com.shurik.gym.database

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import java.util.*

@Dao
interface GymDao {

    companion object {

        const val DATE = "date"
    }
        @Query("SELECT * from gym")
        fun getGym (gymEntity: GymEntity)

        @Query ("SELECT * from gym where $DATE=:date")
        fun getGymByDate (date : Date ) : GymEntity

        @Query("SELECT * from exercises")
        fun getExercise(exerciseEntity: ExerciseEntity)

        @Insert(onConflict = REPLACE)
        fun insertGym (gymEntity: GymEntity)
        fun insertExercise (exerciseEntity: ExerciseEntity)

        @Delete
        fun deleteGym (gymEntity: GymEntity)
}
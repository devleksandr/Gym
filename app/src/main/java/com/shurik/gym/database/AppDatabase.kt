package com.shurik.gym.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context

@Database (entities = arrayOf(GymEntity::class,ExerciseEntity::class),version = 1,exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun gymDao() : GymDao

    companion object {
        private val databaseName = "gymDatabase"

        var dbInstance:GymDao? = null
        fun getInstance (context: Context) : GymDao? {
            if (dbInstance == null)
                dbInstance=Room.inMemoryDatabaseBuilder(context,AppDatabase::class.java).build().gymDao()
            return dbInstance
        }
    }
}
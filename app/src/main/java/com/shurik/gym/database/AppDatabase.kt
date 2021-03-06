package com.shurik.gym.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database (entities = arrayOf(GymEntity::class,ExerciseEntity::class),version = 2,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun gymDao(): GymDao

    abstract fun exerciseDao() : ExerciseDao

    companion object {
        private val databaseName = "gymDatabase"

        var dbInstance: AppDatabase? = null
        fun getInstance(context: Context?): AppDatabase? {
            if (dbInstance == null)
                dbInstance = Room.databaseBuilder(context!!.applicationContext, AppDatabase::class.java, databaseName).allowMainThreadQueries().build()
            return dbInstance
        }
    }
}
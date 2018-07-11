package com.shurik.gym

import android.os.Bundle
import android.support.v7.app.AppCompatActivity



class AddExerciseActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_add)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}